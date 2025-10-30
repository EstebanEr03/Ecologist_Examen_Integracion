package com.ecologistics.integration.routes;

import com.ecologistics.integration.model.EnvioSpec;
import com.ecologistics.integration.service.EnvioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.camel.model.rest.RestParamType.path;

/**
 * Rutas de integración según especificación técnica de EcoLogistics.
 * Implementa el patrón File Transfer y API REST requeridos.
 */
@Component
public class EcoLogisticsSpecRoute extends RouteBuilder {
    
    @Autowired
    private EnvioService envioService;
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void configure() {
        
        // Configuración REST según especificación
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "EcoLogistics API")
            .apiProperty("api.version", "1.0.0")
            .apiProperty("api.description", "API REST para gestión de envíos - EcoLogistics S.A.")
            .apiProperty("cors", "true");

        // API REST según especificación técnica
        rest("/envios").description("Gestión de Envíos - Especificación Técnica")
            .consumes("application/json")
            .produces("application/json")
            
            // GET /envios - Lista todos los envíos
            .get()
                .description("Obtener lista de todos los envíos")
                .responseMessage().code(200).message("Lista de envíos").endResponseMessage()
                .to("direct:listar-envios-spec")
            
            // POST /envios - Registra un nuevo envío
            .post()
                .description("Registrar un nuevo envío")
                .type(EnvioSpec.class)
                .responseMessage().code(201).message("Envío registrado").endResponseMessage()
                .responseMessage().code(400).message("Datos inválidos").endResponseMessage()
                .to("direct:crear-envio-spec")
                
            // GET /envios/{id} - Obtiene un envío específico
            .get("/{id}")
                .description("Obtener un envío específico por ID")
                .param().name("id").type(path).description("ID del envío").dataType("string").endParam()
                .responseMessage().code(200).message("Envío encontrado").endResponseMessage()
                .responseMessage().code(404).message("Envío no encontrado").endResponseMessage()
                .to("direct:obtener-envio-spec");

        // Endpoint de salud
        rest("/health").description("Health Check - Estado del sistema")
            .produces("application/json")
            
            .get()
                .description("Verificar estado del sistema")
                .responseMessage().code(200).message("Sistema operativo").endResponseMessage()
                .to("direct:health-check");

        // Ruta de inicio: Leer archivo CSV y transformar a JSON
        from("timer://inicio?delay=2000&repeatCount=1")
            .routeId("csv-to-json-route")
            .log("[INFO] Iniciando carga de archivo CSV...")
            .to("direct:cargar-csv");

        // Cargar y procesar archivo CSV
        from("direct:cargar-csv")
            .log("[INFO] Leyendo archivo envios.csv...")
            .pollEnrich("file:.?fileName=envios.csv&noop=true&idempotent=false")
            .choice()
                .when(body().isNull())
                    .log("[ERROR] No se pudo leer el archivo envios.csv")
                .otherwise()
                    .log("[INFO] Archivo cargado exitosamente")
                    .to("direct:transformar-csv-json");

        // Transformar CSV a JSON
        from("direct:transformar-csv-json")
            .log("[INFO] Transformando CSV a formato JSON...")
            .process(exchange -> {
                String csvContent = exchange.getIn().getBody(String.class);
                List<EnvioSpec> envios = new ArrayList<>();
                
                String[] lines = csvContent.split("\\n");
                boolean isFirstLine = true;
                int registrosCargados = 0;
                
                for (String line : lines) {
                    line = line.trim();
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Saltar header
                    }
                    
                    if (!line.isEmpty()) {
                        String[] campos = line.split(",");
                        if (campos.length >= 4) {
                            EnvioSpec envio = new EnvioSpec(
                                campos[0].trim(),
                                campos[1].trim(),
                                campos[2].trim(),
                                campos[3].trim()
                            );
                            envios.add(envio);
                            registrosCargados++;
                        }
                    }
                }
                
                System.out.println("[INFO] Archivo cargado con " + registrosCargados + " registros.");
                System.out.println("[INFO] Datos transformados a formato JSON.");
                
                // Cargar en el servicio
                envioService.cargarEnvios(envios);
                
                exchange.getIn().setBody(envios);
            })
            .log("[INFO] Transformación completada. API lista para recibir consultas.");

        // Implementaciones de los endpoints REST

        // GET /envios - Listar todos los envíos
        from("direct:listar-envios-spec")
            .log("[INFO] Solicitud GET /envios recibida")
            .process(exchange -> {
                List<EnvioSpec> envios = envioService.obtenerTodosLosEnvios();
                exchange.getIn().setBody(envios);
                exchange.getIn().setHeader("Content-Type", "application/json");
                System.out.println("[INFO] Respondiendo con " + envios.size() + " envíos");
            });

        // POST /envios - Crear nuevo envío
        from("direct:crear-envio-spec")
            .log("[INFO] Solicitud POST /envios recibida")
            .process(exchange -> {
                // El body ya viene como EnvioSpec gracias al binding automático de Camel
                EnvioSpec nuevoEnvio = exchange.getIn().getBody(EnvioSpec.class);
                
                EnvioSpec envioRegistrado = envioService.registrarEnvio(nuevoEnvio);
                
                exchange.getIn().setBody(envioRegistrado);
                exchange.getIn().setHeader("Content-Type", "application/json");
                exchange.getIn().setHeader(exchange.HTTP_RESPONSE_CODE, 201);
                
                System.out.println("[INFO] Nuevo envío registrado: " + envioRegistrado.getId());
            });

        // GET /envios/{id} - Obtener envío por ID
        from("direct:obtener-envio-spec")
            .log("[INFO] Solicitud GET /envios/${header.id} recibida")
            .process(exchange -> {
                String envioId = exchange.getIn().getHeader("id", String.class);
                Optional<EnvioSpec> envio = envioService.obtenerEnvioPorId(envioId);
                
                if (envio.isPresent()) {
                    exchange.getIn().setBody(envio.get());
                    exchange.getIn().setHeader("Content-Type", "application/json");
                    System.out.println("[INFO] Envío encontrado: " + envioId);
                } else {
                    exchange.getIn().setBody("{\"error\":\"Envío no encontrado\"}");
                    exchange.getIn().setHeader("Content-Type", "application/json");
                    exchange.getIn().setHeader(exchange.HTTP_RESPONSE_CODE, 404);
                    System.out.println("[WARN] Envío no encontrado: " + envioId);
                }
            });

        // GET /health - Health Check
        from("direct:health-check")
            .log("[INFO] Solicitud GET /health recibida")
            .process(exchange -> {
                java.util.Map<String, Object> healthStatus = new java.util.HashMap<>();
                healthStatus.put("status", "UP");
                healthStatus.put("application", "EcoLogistics Integration System");
                healthStatus.put("version", "1.0.0");
                healthStatus.put("timestamp", java.time.LocalDateTime.now().toString());
                healthStatus.put("enviosCount", envioService.getTotalEnvios());
                
                exchange.getIn().setBody(healthStatus);
                exchange.getIn().setHeader("Content-Type", "application/json");
                System.out.println("[INFO] Health check - Sistema operativo");
            });
    }
}
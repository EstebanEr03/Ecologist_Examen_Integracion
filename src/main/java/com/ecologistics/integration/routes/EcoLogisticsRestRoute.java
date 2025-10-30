package com.ecologistics.integration.routes;

import com.ecologistics.integration.model.Envio;
import com.ecologistics.integration.model.Vehiculo;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

import static org.apache.camel.model.rest.RestParamType.path;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Rutas REST API para el sistema EcoLogistics.
 * Proporciona endpoints para gestión de envíos y vehículos.
 */
//@Component - Deshabilitado temporalmente para usar EcoLogisticsSpecRoute
public class EcoLogisticsRestRoute extends RouteBuilder {
    
    private static final AtomicInteger envioCounter = new AtomicInteger(1);
    private static final AtomicInteger vehiculoCounter = new AtomicInteger(1);
    
    @Override
    public void configure() {
        
        // Configuración REST para EcoLogistics
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .contextPath("/api")
            .port(8081)
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "EcoLogistics API")
            .apiProperty("api.version", "1.0.0")
            .apiProperty("api.description", "Sistema de integración para gestión de envíos y vehículos - EcoLogistics S.A.")
            .apiProperty("cors", "true");

        // REST API para gestión de envíos
        rest("/envios").description("Gestión de Envíos EcoLogistics")
            .consumes("application/json")
            .produces("application/json")
            
            // GET /api/envios - Listar todos los envíos
            .get()
                .description("Obtener lista de todos los envíos")
                .responseMessage().code(200).message("Lista de envíos").endResponseMessage()
                .to("direct:listar-envios")
            
            // POST /api/envios - Crear nuevo envío
            .post()
                .description("Crear un nuevo envío")
                .type(Envio.class)
                .responseMessage().code(201).message("Envío creado").endResponseMessage()
                .responseMessage().code(400).message("Datos inválidos").endResponseMessage()
                .to("direct:crear-envio")
                
            // GET /api/envios/{id} - Obtener envío por ID
            .get("/{id}")
                .description("Obtener un envío específico por ID")
                .param().name("id").type(path).description("ID del envío").dataType("string").endParam()
                .responseMessage().code(200).message("Envío encontrado").endResponseMessage()
                .responseMessage().code(404).message("Envío no encontrado").endResponseMessage()
                .to("direct:obtener-envio");

        // REST API para gestión de vehículos
        rest("/vehiculos").description("Gestión de Vehículos EcoLogistics")
            .consumes("application/json")
            .produces("application/json")
            
            // GET /api/vehiculos - Listar todos los vehículos
            .get()
                .description("Obtener lista de todos los vehículos")
                .responseMessage().code(200).message("Lista de vehículos").endResponseMessage()
                .to("direct:listar-vehiculos")
            
            // POST /api/vehiculos - Registrar nuevo vehículo
            .post()
                .description("Registrar un nuevo vehículo")
                .type(Vehiculo.class)
                .responseMessage().code(201).message("Vehículo registrado").endResponseMessage()
                .responseMessage().code(400).message("Datos inválidos").endResponseMessage()
                .to("direct:crear-vehiculo")
                
            // GET /api/vehiculos/disponibles - Obtener vehículos disponibles
            .get("/disponibles")
                .description("Obtener lista de vehículos disponibles")
                .responseMessage().code(200).message("Lista de vehículos disponibles").endResponseMessage()
                .to("direct:vehiculos-disponibles");

        // Implementación de las rutas directas
        
        // Ruta para listar envíos
        from("direct:listar-envios")
            .log("Procesando solicitud para listar envíos")
            .process(exchange -> {
                // Simulamos datos de envíos (en una implementación real vendría de BD)
                String jsonResponse = """
                    [
                        {
                            "id": "ENV001",
                            "origen": "Bogotá",
                            "destino": "Medellín",
                            "descripcion": "Paquete de documentos",
                            "peso": 2.5,
                            "estado": "EN_TRANSITO",
                            "fechaCreacion": "2025-10-29 10:30:00",
                            "vehiculoAsignado": "VEH001"
                        },
                        {
                            "id": "ENV002",
                            "origen": "Cali",
                            "destino": "Cartagena",
                            "descripcion": "Equipos electrónicos",
                            "peso": 15.0,
                            "estado": "PENDIENTE",
                            "fechaCreacion": "2025-10-29 11:15:00",
                            "vehiculoAsignado": null
                        }
                    ]
                    """;
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
            });

        // Ruta para crear envío
        from("direct:crear-envio")
            .log("Procesando creación de nuevo envío")
            .process(exchange -> {
                String envioId = "ENV" + String.format("%03d", envioCounter.getAndIncrement());
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                
                String jsonResponse = String.format("""
                    {
                        "id": "%s",
                        "estado": "CREADO",
                        "fechaCreacion": "%s",
                        "mensaje": "Envío creado exitosamente"
                    }
                    """, envioId, timestamp);
                
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
                exchange.getIn().setHeader(exchange.HTTP_RESPONSE_CODE, 201);
            });

        // Ruta para obtener envío por ID
        from("direct:obtener-envio")
            .log("Obteniendo envío con ID: ${header.id}")
            .process(exchange -> {
                String envioId = exchange.getIn().getHeader("id", String.class);
                String jsonResponse = String.format("""
                    {
                        "id": "%s",
                        "origen": "Bogotá",
                        "destino": "Medellín",
                        "descripcion": "Paquete específico",
                        "peso": 5.0,
                        "estado": "EN_TRANSITO",
                        "fechaCreacion": "2025-10-29 10:30:00",
                        "vehiculoAsignado": "VEH001"
                    }
                    """, envioId);
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
            });

        // Ruta para listar vehículos
        from("direct:listar-vehiculos")
            .log("Procesando solicitud para listar vehículos")
            .process(exchange -> {
                String jsonResponse = """
                    [
                        {
                            "id": "VEH001",
                            "placa": "ABC123",
                            "tipo": "CAMION",
                            "capacidad": 1500.0,
                            "estado": "EN_RUTA",
                            "conductor": "Juan Pérez",
                            "ubicacionActual": "Medellín"
                        },
                        {
                            "id": "VEH002",
                            "placa": "DEF456",
                            "tipo": "FURGONETA",
                            "capacidad": 800.0,
                            "estado": "DISPONIBLE",
                            "conductor": "María González",
                            "ubicacionActual": "Bogotá"
                        }
                    ]
                    """;
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
            });

        // Ruta para crear vehículo
        from("direct:crear-vehiculo")
            .log("Procesando registro de nuevo vehículo")
            .process(exchange -> {
                String vehiculoId = "VEH" + String.format("%03d", vehiculoCounter.getAndIncrement());
                
                String jsonResponse = String.format("""
                    {
                        "id": "%s",
                        "estado": "REGISTRADO",
                        "mensaje": "Vehículo registrado exitosamente"
                    }
                    """, vehiculoId);
                
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
                exchange.getIn().setHeader(exchange.HTTP_RESPONSE_CODE, 201);
            });

        // Ruta para vehículos disponibles
        from("direct:vehiculos-disponibles")
            .log("Obteniendo vehículos disponibles")
            .process(exchange -> {
                String jsonResponse = """
                    [
                        {
                            "id": "VEH002",
                            "placa": "DEF456",
                            "tipo": "FURGONETA",
                            "capacidad": 800.0,
                            "estado": "DISPONIBLE",
                            "conductor": "María González",
                            "ubicacionActual": "Bogotá"
                        },
                        {
                            "id": "VEH003",
                            "placa": "GHI789",
                            "tipo": "CAMION",
                            "capacidad": 2000.0,
                            "estado": "DISPONIBLE",
                            "conductor": "Carlos Rodríguez",
                            "ubicacionActual": "Cali"
                        }
                    ]
                    """;
                exchange.getIn().setBody(jsonResponse);
                exchange.getIn().setHeader("Content-Type", "application/json");
            });
    }
}
package com.ecologistics.integration.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Rutas de procesamiento de archivos CSV para EcoLogistics.
 * Simula el procesamiento de archivos CSV enviados por supervisores.
 */
//@Component - Deshabilitado temporalmente para usar EcoLogisticsSpecRoute
public class FileProcessingRoute extends RouteBuilder {

    @Override
    public void configure() {
        
        // Ruta para procesar archivos CSV de envíos
        from("file:input?include=.*\\.csv&delay=5000&autoCreate=true")
            .routeId("csv-processing-route")
            .log("Procesando archivo CSV: ${header.CamelFileName}")
            .choice()
                .when(header("CamelFileName").contains("envios"))
                    .to("direct:procesar-envios-csv")
                .when(header("CamelFileName").contains("vehiculos"))
                    .to("direct:procesar-vehiculos-csv")
                .otherwise()
                    .log("Tipo de archivo no reconocido: ${header.CamelFileName}")
                    .to("direct:archivo-no-procesado")
            .end();

        // Procesamiento específico para archivos de envíos
        from("direct:procesar-envios-csv")
            .log("Procesando archivo de envíos: ${header.CamelFileName}")
            .process(exchange -> {
                String fileName = exchange.getIn().getHeader("CamelFileName", String.class);
                String content = exchange.getIn().getBody(String.class);
                
                // Simulamos el procesamiento del CSV
                String[] lines = content.split("\\n");
                int totalEnvios = Math.max(0, lines.length - 1); // Excluir header
                
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
                String processedFileName = "envios-" + timestamp + ".csv";
                
                exchange.getIn().setHeader("ProcessedFileName", processedFileName);
                exchange.getIn().setHeader("TotalEnvios", totalEnvios);
                
                log.info("Procesados {} envíos del archivo {}", totalEnvios, fileName);
            })
            .to("direct:guardar-archivo-procesado");

        // Procesamiento específico para archivos de vehículos
        from("direct:procesar-vehiculos-csv")
            .log("Procesando archivo de vehículos: ${header.CamelFileName}")
            .process(exchange -> {
                String fileName = exchange.getIn().getHeader("CamelFileName", String.class);
                String content = exchange.getIn().getBody(String.class);
                
                String[] lines = content.split("\\n");
                int totalVehiculos = Math.max(0, lines.length - 1);
                
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
                String processedFileName = "vehiculos-" + timestamp + ".csv";
                
                exchange.getIn().setHeader("ProcessedFileName", processedFileName);
                exchange.getIn().setHeader("TotalVehiculos", totalVehiculos);
                
                log.info("Procesados {} vehículos del archivo {}", totalVehiculos, fileName);
            })
            .to("direct:guardar-archivo-procesado");

        // Guardar archivo procesado
        from("direct:guardar-archivo-procesado")
            .setHeader("CamelFileName", simple("${header.ProcessedFileName}"))
            .to("file:output?autoCreate=true")
            .log("Archivo procesado guardado como: ${header.ProcessedFileName}")
            .to("direct:archivar-original");

        // Archivar archivo original
        from("direct:archivar-original")
            .setHeader("CamelFileName", simple("${header.CamelFileNameOnly}"))
            .to("file:archived?autoCreate=true")
            .log("Archivo original archivado: ${header.CamelFileNameOnly}");

        // Manejo de archivos no procesados
        from("direct:archivo-no-procesado")
            .log("Archivo no procesado, moviendo a carpeta de no procesados: ${header.CamelFileName}")
            .to("file:output/no-procesados?autoCreate=true");
    }
}
package com.ecologistics.integration;

import org.apache.camel.component.servlet.springboot.ServletMappingAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Aplicación principal de EcoLogistics S.A.
 * Sistema de integración para modernizar el ecosistema tecnológico
 * de transporte y distribución.
 */
@SpringBootApplication(exclude = {ServletMappingAutoConfiguration.class})
@ComponentScan(basePackages = "com.ecologistics.integration")
public class EcoLogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoLogisticsApplication.class, args);
    }
}
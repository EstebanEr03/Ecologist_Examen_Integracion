package com.ecologistics.integration.config;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Servlets para EcoLogistics.
 * Registra el CamelHttpTransportServlet con alta prioridad para capturar
 * las peticiones a /api/* antes que el DispatcherServlet de Spring.
 */
@Configuration
public class ServletConfig {
    
    @Bean
    public ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
        // Crear el servlet de Camel
        CamelHttpTransportServlet camelServlet = new CamelHttpTransportServlet();
        
        // Registrar el servlet en el path /api/*
        ServletRegistrationBean<CamelHttpTransportServlet> registration = 
            new ServletRegistrationBean<>(camelServlet, "/api/*");
        
        // Configurar el nombre del servlet
        registration.setName("CamelServlet");
        
        // IMPORTANTE: Cargar el servlet al inicio con prioridad alta
        // Números más bajos = mayor prioridad (se cargan primero)
        registration.setLoadOnStartup(1);
        
        return registration;
    }
}

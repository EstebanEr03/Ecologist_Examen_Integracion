package com.ecologistics.integration.service;

import com.ecologistics.integration.model.EnvioSpec;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Servicio para gestión de envíos en memoria.
 * Mantiene los datos transformados desde CSV en estructura temporal.
 */
@Service
public class EnvioService {
    
    private final Map<String, EnvioSpec> envios = new ConcurrentHashMap<>();
    private final AtomicInteger contador = new AtomicInteger(4); // Siguiente ID después de 003
    
    /**
     * Cargar envíos desde datos CSV transformados
     */
    public void cargarEnvios(List<EnvioSpec> enviosList) {
        envios.clear();
        for (EnvioSpec envio : enviosList) {
            envios.put(envio.getId(), envio);
        }
        System.out.println("[INFO] Datos transformados cargados en memoria: " + envios.size() + " registros.");
    }
    
    /**
     * Obtener todos los envíos
     */
    public List<EnvioSpec> obtenerTodosLosEnvios() {
        return new ArrayList<>(envios.values());
    }
    
    /**
     * Obtener envío por ID
     */
    public Optional<EnvioSpec> obtenerEnvioPorId(String id) {
        return Optional.ofNullable(envios.get(id));
    }
    
    /**
     * Registrar nuevo envío
     */
    public EnvioSpec registrarEnvio(EnvioSpec nuevoEnvio) {
        // Generar ID automático si no se proporciona
        if (nuevoEnvio.getId() == null || nuevoEnvio.getId().isEmpty()) {
            String nuevoId = String.format("%03d", contador.getAndIncrement());
            nuevoEnvio.setId(nuevoId);
        }
        
        envios.put(nuevoEnvio.getId(), nuevoEnvio);
        System.out.println("[INFO] Nuevo envío registrado: " + nuevoEnvio);
        return nuevoEnvio;
    }
    
    /**
     * Obtener estadísticas
     */
    public int getTotalEnvios() {
        return envios.size();
    }
}
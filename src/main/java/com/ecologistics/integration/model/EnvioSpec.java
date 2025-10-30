package com.ecologistics.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modelo de datos para envíos según especificación técnica de EcoLogistics.
 * Estructura: {id, cliente, direccion, estado}
 */
public class EnvioSpec {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("cliente")
    private String cliente;
    
    @JsonProperty("direccion")
    private String direccion;
    
    @JsonProperty("estado")
    private String estado;
    
    // Constructor por defecto
    public EnvioSpec() {}
    
    // Constructor completo
    public EnvioSpec(String id, String cliente, String direccion, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    @Override
    public String toString() {
        return String.format("EnvioSpec{id='%s', cliente='%s', direccion='%s', estado='%s'}", 
                           id, cliente, direccion, estado);
    }
}
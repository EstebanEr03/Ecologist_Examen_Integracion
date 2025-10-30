package com.ecologistics.integration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 * Modelo de datos para representar un envío en el sistema EcoLogistics.
 * Contiene la información básica de los envíos gestionados por la empresa.
 */
public class Envio {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("origen")
    private String origen;
    
    @JsonProperty("destino")
    private String destino;
    
    @JsonProperty("descripcion")
    private String descripcion;
    
    @JsonProperty("peso")
    private Double peso;
    
    @JsonProperty("estado")
    private String estado;
    
    @JsonProperty("fechaCreacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCreacion;
    
    @JsonProperty("vehiculoAsignado")
    private String vehiculoAsignado;
    
    // Constructor por defecto
    public Envio() {}
    
    // Constructor completo
    public Envio(String id, String origen, String destino, String descripcion, 
                 Double peso, String estado, LocalDateTime fechaCreacion, String vehiculoAsignado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.descripcion = descripcion;
        this.peso = peso;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.vehiculoAsignado = vehiculoAsignado;
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    public String getVehiculoAsignado() { return vehiculoAsignado; }
    public void setVehiculoAsignado(String vehiculoAsignado) { this.vehiculoAsignado = vehiculoAsignado; }
    
    @Override
    public String toString() {
        return String.format("Envio{id='%s', origen='%s', destino='%s', estado='%s'}", 
                           id, origen, destino, estado);
    }
}
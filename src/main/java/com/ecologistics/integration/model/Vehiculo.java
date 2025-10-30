package com.ecologistics.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modelo de datos para representar un vehículo en el sistema EcoLogistics.
 * Contiene la información de los vehículos disponibles para distribución.
 */
public class Vehiculo {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("placa")
    private String placa;
    
    @JsonProperty("tipo")
    private String tipo;
    
    @JsonProperty("capacidad")
    private Double capacidad;
    
    @JsonProperty("estado")
    private String estado; // DISPONIBLE, EN_RUTA, MANTENIMIENTO
    
    @JsonProperty("conductor")
    private String conductor;
    
    @JsonProperty("ubicacionActual")
    private String ubicacionActual;
    
    // Constructor por defecto
    public Vehiculo() {}
    
    // Constructor completo
    public Vehiculo(String id, String placa, String tipo, Double capacidad, 
                   String estado, String conductor, String ubicacionActual) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.estado = estado;
        this.conductor = conductor;
        this.ubicacionActual = ubicacionActual;
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public Double getCapacidad() { return capacidad; }
    public void setCapacidad(Double capacidad) { this.capacidad = capacidad; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public String getConductor() { return conductor; }
    public void setConductor(String conductor) { this.conductor = conductor; }
    
    public String getUbicacionActual() { return ubicacionActual; }
    public void setUbicacionActual(String ubicacionActual) { this.ubicacionActual = ubicacionActual; }
    
    @Override
    public String toString() {
        return String.format("Vehiculo{id='%s', placa='%s', tipo='%s', estado='%s'}", 
                           id, placa, tipo, estado);
    }
}
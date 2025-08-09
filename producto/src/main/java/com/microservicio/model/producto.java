package com.microservicio.model;


import io.swagger.v3.oas.annotations.media.Schema;

// Usamos Lombok para reducir el código boilerplate (getters, setters, constructor)
// Si no usas Lombok, deberás generar estos métodos manualmente.
// @Data // Descomenta si usas Lombok y no quieres las anotaciones individuales

public class producto {


    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    private String nombre;

    @Schema(description = "Descripción detallada del producto", example = "Potente laptop con pantalla 4K y procesador i7")
    private String descripcion;

    @Schema(description = "Precio unitario del producto", example = "1200.50")
    private double precio;

    // Constructor vacío (necesario para algunas bibliotecas)
    public producto() {
    }

    // Constructor con todos los campos
    public producto(Long id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public double getPrecio() {
        return precio;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
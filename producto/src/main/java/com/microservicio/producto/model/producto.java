package com.microservicio.producto.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "producto") // Nombre de la colección en MongoDB
@Data // Genera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos

public class producto {

    @Id // Indica que este es el campo _id en MongoDB
    private String id;
    private String nombre;
    private double precio;
    private String descripción ;

    // Lombok se encarga de getters, setters, etc.
}
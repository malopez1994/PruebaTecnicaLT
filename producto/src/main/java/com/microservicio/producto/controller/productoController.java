package com.microservicio.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.producto.model.producto;
import com.microservicio.producto.service.productoService;


/*
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.model.producto;
import com.microservicio.service.productoService;





import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;*/

@RestController
@RequestMapping("/api/producto") // Prefijo base para todos los endpoints de este controlador

//@Tag(name = "User Management", description = "API para gestionar usuarios") // Etiqueta de Swagger
public class productoController {

    private final productoService productoService;

    @Autowired
    public productoController(productoService productoService) {
        this.productoService = productoService;
    }

   // @Operation(summary = "Obtener todos los usuarios", description = "Recupera una lista de todos los usuarios registrados.")
    @GetMapping
    public ResponseEntity<List<producto>> getAllProductos() {
        List<producto> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    //@Operation(summary = "Obtener usuario por ID", description = "Recupera un usuario específico por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<producto> getProductoById(@PathVariable String id) {
        Optional<producto> producto = productoService.getProductoById(id);
        return producto.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

   // @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en el sistema.")
    @PostMapping
    public ResponseEntity<producto> createProducto(@RequestBody producto producto) {
        producto createdProducto = productoService.createProducto(producto);
        // Spring Web MVC puede manejar la generación del ID si lo dejas nulo o generas uno
        // Para MongoDB, el ID se genera automáticamente si no se proporciona.
        // Sin embargo, para que el cliente conozca el ID, deberíamos devolverlo.
        // Spring Data MongoDB se encarga de asignarlo al objeto 'createdUser'.
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }
}
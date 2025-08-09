package com.microservicio.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.model.producto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products") // Define la ruta base para este controlador
@Tag(name = "Product", description = "API para gestionar el inventario de productos") // Etiqueta para agrupar operaciones en Swagger
public class ProductoController {

    // Simula una base de datos en memoria
    private static final List<producto> productInventory = new ArrayList<>();
    private static final AtomicLong idCounter = new AtomicLong(1L); // Generador de IDs

    // --- GET all products ---
    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos disponibles en el inventario.")
    @ApiResponse(responseCode = "200", description = "Lista de productos", content = @Content(schema = @Schema(implementation = producto.class)))
    public ResponseEntity<List<producto>> getAllProducts() {
        return ResponseEntity.ok(productInventory);
    }

    // --- GET product by ID ---
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por su ID", description = "Busca y devuelve un producto específico usando su identificador único.")
    @Parameter(name = "id", description = "ID del producto a buscar", required = true, example = "1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado", content = @Content(schema = @Schema(implementation = producto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    public ResponseEntity<producto> getProductById(@PathVariable Long id) {
        producto product = productInventory.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra
        }
    }

    // --- POST create product ---
    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Agrega un nuevo producto al inventario.")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente", content = @Content(schema = @Schema(implementation = producto.class)))
    public ResponseEntity<producto> createProduct(@RequestBody producto product) {
        // Asignar un nuevo ID
        product.setId(idCounter.getAndIncrement());
        productInventory.add(product);
        // Devuelve el producto creado con el status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}
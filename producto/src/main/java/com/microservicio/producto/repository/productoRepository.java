package com.microservicio.producto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservicio.producto.model.producto;


public interface productoRepository extends MongoRepository<producto, String> {
    // Spring Data MongoDB generará automáticamente las implementaciones para
    // operaciones CRUD básicas (save, findById, findAll, delete, etc.)
    // Puedes añadir métodos de consulta personalizados aquí si los necesitas.
    // Ejemplo: User findByEmail(String email);
}
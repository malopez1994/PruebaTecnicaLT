package com.microservicio.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.producto.model.producto;
import com.microservicio.producto.repository.productoRepository;

@Service // Indica que esta clase contiene lógica de negocio
public class productoService {

    private final productoRepository productoRepository;

    @Autowired // Inyecta la dependencia del UserRepository
    public productoService(productoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<producto> getProductoById(String id) {
        return productoRepository.findById(id);
    }

    public producto createProducto(producto producto) {
        // Podrías añadir validaciones aquí antes de guardar
        return productoRepository.save(producto);
    }

}
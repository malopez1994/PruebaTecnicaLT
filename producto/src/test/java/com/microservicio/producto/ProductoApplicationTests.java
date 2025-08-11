package com.microservicio.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservicio.producto.model.producto;
import com.microservicio.producto.repository.productoRepository;
import com.microservicio.producto.service.productoService;
/*
@SpringBootTest
class ProductoApplicationTests {

	@Test
	void contextLoads() {
	}

}*/


@ExtendWith(MockitoExtension.class)
public class ProductoApplicationTests {

    @Mock
    private productoRepository productoRepository;

    @InjectMocks
    private productoService productoService;

    @Test
    void testCrearProducto() {
        producto producto = new producto();
        producto.setNombre("Chocolate");
        producto.setDescripción("Chocolate corona 500 gr");

        when(productoRepository.save(producto)).thenReturn(producto);

        producto resultado = productoService.createProducto(producto);

        assertEquals("Chocolate", resultado.getNombre());
        verify(productoRepository).save(producto);
    }
}


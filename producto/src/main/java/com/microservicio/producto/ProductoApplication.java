package com.microservicio.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
        System.out.println("Inventory Service started! Access Swagger UI at http://localhost:8080/swagger-ui.html");

}
}
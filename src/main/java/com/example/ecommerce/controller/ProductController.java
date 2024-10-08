package com.example.ecommerce.controller;

import com.example.ecommerce.configuracion.Configuracion;
import com.example.ecommerce.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductDAO productDAO;

    public ProductController() {

        String dbType = "mysql";
        productDAO = new ProductDAO(Configuracion.configureAdapterDB(dbType));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productDAO.create(product);
        String dbName = productDAO.getDatabaseType();
        String message = "Producto creado en la base de datos: " + dbName;
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        productDAO.update(product);
        String dbName = productDAO.getDatabaseType();
        String message = "Producto actualizado en la base de datos: " + dbName;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productDAO.delete(id);
        String dbName = productDAO.getDatabaseType(); 
        String message = "Producto borrado en la base de datos: " + dbName;
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }

}

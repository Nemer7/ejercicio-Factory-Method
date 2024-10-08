package com.example.ecommerce.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleDB implements  IProductDB{

    private Map<Integer, Product> productosMap = new HashMap<>();

    public OracleDB() {

        productosMap.put(1, new Product(1, "Laptop-O", 1200.99));
        productosMap.put(2, new Product(2, "Mouse-O", 25.50));
    }

    @Override
    public void create(Product product) {
        productosMap.put(product.getId(), product);
    }

    @Override
    public Product read(int id) {
        return productosMap.get(id);
    }

    @Override
    public void update(Product product) {
        productosMap.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productosMap.remove(id);
    }

    @Override
    public List<Product> getAll() {
        return productosMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public String getDatabaseType() {
        return "Oracle";
    }
}

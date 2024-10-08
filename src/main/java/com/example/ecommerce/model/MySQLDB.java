package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class MySQLDB implements  IProductDB {

    private List<Product> productosList = new ArrayList<>();

    public MySQLDB() {

        productosList.add(new Product(1, "Laptop", 1200.99));
        productosList.add(new Product(2, "Mouse", 25.50));
    }

    @Override
    public void create(Product product) {
        productosList.add(product);
    }

    @Override
    public Product read(int id) {
        return productosList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Product product) {
        productosList.replaceAll(p -> p.getId() == product.getId() ? product : p);
    }

    @Override
    public void delete(int id) {
        productosList.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> getAll() {
        return productosList;
    }

    @Override
    public String getDatabaseType() {
        return "MySQL";
    }
}

package com.example.ecommerce.model;

import java.util.List;

public interface IProductDB {

    void create(Product product);
    Product read(int id);
    void update(Product product);
    void delete(int id);
    List<Product> getAll();
    String getDatabaseType();
}

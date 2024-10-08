package com.example.ecommerce.model;

import java.util.List;

public class ProductDAO {

    private IProductDB db;

    public ProductDAO(IProductDB db) {
        this.db = db;
    }

    public void create(Product product) {
        db.create(product);
    }

    public Product read(int id) {
        return db.read(id);
    }

    public void update(Product product) {
        db.update(product);
    }

    public void delete(int id) {
        db.delete(id);
    }

    public List<Product> getAll() {
        return db.getAll();
    }


    public String getDatabaseType() {
        return db.getDatabaseType();
    }
}

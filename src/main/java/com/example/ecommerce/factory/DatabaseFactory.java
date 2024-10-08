package com.example.ecommerce.factory;

import com.example.ecommerce.model.IProductDB;

public interface DatabaseFactory {

    IProductDB createDBAdapter();
}

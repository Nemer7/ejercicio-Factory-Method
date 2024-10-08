package com.example.ecommerce.factory;

import com.example.ecommerce.model.*;

public class OracleFactory implements DatabaseFactory{

    @Override
    public IProductDB createDBAdapter() {
        return new OracleDB();
    }
}

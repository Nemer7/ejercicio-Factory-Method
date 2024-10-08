package com.example.ecommerce.factory;

import com.example.ecommerce.model.*;


public class MySQLFactory  implements DatabaseFactory{

    @Override
    public IProductDB createDBAdapter() {
        return new MySQLDB();
    }
}

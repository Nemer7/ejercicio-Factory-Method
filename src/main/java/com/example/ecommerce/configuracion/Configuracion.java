package com.example.ecommerce.configuracion;

import com.example.ecommerce.model.*;
import com.example.ecommerce.factory.*;

import java.util.HashMap;
import java.util.Map;


public class Configuracion {

    private static final Map<String, DatabaseFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("mysql", new MySQLFactory());
        factoryMap.put("oracle", new OracleFactory());
    }

    public static IProductDB configureAdapterDB(String dbType) {
        DatabaseFactory factory = factoryMap.get(dbType.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unsupported DB type: " + dbType);
        }
        return factory.createDBAdapter();
    }
}

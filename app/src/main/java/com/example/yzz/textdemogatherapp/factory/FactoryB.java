package com.example.yzz.textdemogatherapp.factory;

/**
 * Created by yzz on 2017/11/3 0003.
 */
public class FactoryB extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}

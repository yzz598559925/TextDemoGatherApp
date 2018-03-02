package com.example.yzz.textdemogatherapp.factory;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
public class FactoryA extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

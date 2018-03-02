package com.example.yzz.textdemogatherapp.builder;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
public class Director {
    //指挥装机人员组装电脑
    public void Construct(Builder builder) {

        builder.BuildCPU();
        builder.BuildMainboard();
        builder.BuildHD();
    }

}

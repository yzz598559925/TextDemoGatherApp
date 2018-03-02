package com.example.yzz.textdemogatherapp.builder;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
public class ConcreteBuilder extends Builder {

    //创建产品实例
    Computer computer = new Computer();

    @Override
    public void BuildCPU() {
        computer.Add("组装CPU");
    }

    @Override
    public void BuildMainboard() {
        computer.Add("组装主板");
    }

    @Override
    public void BuildHD() {
        computer.Add("组装主板");
    }

    @Override
    public Computer GetComputer() {
        return computer;
    }
}

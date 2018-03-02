package com.example.yzz.textdemogatherapp.utils;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public class CeShiClass {

    private NumberCallBack numberCallBack;

    private static volatile CeShiClass c = null;

    private CeShiClass() {

    }

    public static CeShiClass getCeShi() {
        if (c == null) {
            c = new CeShiClass();
        }
        return c;
    }

    public void setNumber(NumberCallBack numberCallBack) {
        this.numberCallBack = numberCallBack;
    }

    public void set(int number) {
        set(number, numberCallBack);
    }

    public void set(int number, NumberCallBack numberCallBack) {
        this.numberCallBack = numberCallBack;
        numberCallBack.GetNumber(number);
        numberCallBack.GetMaXNumber(1);
    }
}

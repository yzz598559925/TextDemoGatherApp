package com.example.yzz.textdemogatherapp.proxy;

import android.util.Log;

/**
 * Created by yzz on 2017/11/3 0003.
 * 静态代理模式第二步（确定目标对象）
 */
public class TargetObject implements MyJieKou {
    @Override
    public void Save() {
        Log.i("yzz","我是目标对象");
    }
}

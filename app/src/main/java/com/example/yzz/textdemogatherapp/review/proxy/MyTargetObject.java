package com.example.yzz.textdemogatherapp.review.proxy;

import android.util.Log;

/**
 * Created by yzz on 2017/11/6 0006.
 * 目标对象
 */
public class MyTargetObject implements ProxyInterface {
    @Override
    public void mSuccess() {
        Log.i("yzz", "我是目标对象2");
    }
}

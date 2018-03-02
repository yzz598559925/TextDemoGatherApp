package com.example.yzz.textdemogatherapp.review.proxy;

import android.util.Log;

/**
 * Created by yzz on 2017/11/6 0006.
 * 代理对象
 */
public class MyProxyObject implements ProxyInterface {
    private ProxyInterface mProxyInterface;

    public MyProxyObject(ProxyInterface proxyInterface) {
        this.mProxyInterface = proxyInterface;
    }

    @Override
    public void mSuccess() {
        Log.i("yzz", "我是代理对象2");
        mProxyInterface.mSuccess();
    }
}

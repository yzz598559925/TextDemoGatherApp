package com.example.yzz.textdemogatherapp.review.proxy2;

import android.util.Log;

/**
 * Created by yzz on 2017/11/6 0006.
 * 代理对象
 */
public class BaseProxyObject extends BaseProxy {
    private BaseTargetObject mBaseProxy;

    public BaseProxyObject(BaseTargetObject mBaseProxy) {
        this.mBaseProxy = mBaseProxy;
    }

    @Override
    public void getData() {
        Log.i("yzz", "代理对象Base");
        mBaseProxy.getData();
    }
}

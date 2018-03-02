package com.example.yzz.textdemogatherapp.proxy;

import android.util.Log;

/**
 * Created by yzz on 2017/11/3 0003.
 * 静态代理模式第3步（确定代理对象）
 */
public class ProxyObject implements MyJieKou {
    private MyJieKou myJieKou;

    public ProxyObject(MyJieKou myJieKou) {
        this.myJieKou = myJieKou;
    }

    @Override
    public void Save() {
        Log.i("yzz", "我是代理对象");
        myJieKou.Save();
    }
}

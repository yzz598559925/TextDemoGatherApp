package com.example.yzz.textdemogatherapp.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/**
 * Created by yzz on 2017/11/2 0002.
 * 检查手机是否设置了代理（可以做的工作是如果有代理就停止接口的请求）
 */
public class CheckProxy {
    private Context mContext;

    public CheckProxy(Context context) {
        this.mContext = context;
    }

    public boolean isWifiProxy() {
        final boolean IS_ICS_OR_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
        String proxyAddress;
        int proxyPort;
        if (IS_ICS_OR_LATER) {
            proxyAddress = System.getProperty("http.proxyHost");
            String portStr = System.getProperty("http.proxyPort");
            proxyPort = Integer.parseInt((portStr != null ? portStr : "-1"));
        } else {
            proxyAddress = android.net.Proxy.getHost(mContext);
            proxyPort = android.net.Proxy.getPort(mContext);
        }
        return (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
    }
}

package com.example.yzz.textdemogatherapp.viewpager;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.yzz.textdemogatherapp.R;


/**
 * Created by yzz on 2017/10/18 0018.
 */
public class Activity_material_viewpager extends AppCompatActivity {
    WebView webView;
    String url;
    LinearLayout webViewLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_viewpager);
        url = getIntent().getStringExtra("url");
        Log.i("yzz", "url==" + url);
        webView = (WebView) findViewById(R.id.webview);
        webViewLayout = (LinearLayout) findViewById(R.id.webViewLayout);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(true);// 支持缩放
        webSettings.setUseWideViewPort(true);// 设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);//适配
        webSettings.setDefaultTextEncodingName("utf-8");// 设置默认的文本编码方式
        webSettings.setJavaScriptEnabled(true);  //支持js
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);  //设置 缓存模式
        webSettings.setDomStorageEnabled(true);// 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);//开启 database storage API 功能
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
        webSettings.setBlockNetworkImage(false);//关闭加载网络图片，在一开始加载的时候可以设置为true，当加载完网页的时候再设置为false
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);//不保存密码
        webSettings.setAllowFileAccess(false);
//        webSettings.setTextZoom(75);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAppCacheEnabled(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                if (Build.VERSION.SDK_INT >= 21) {
//                    Log.i("yzz", "urllll===" + request.getUrl());
//                }
//                return super.shouldOverrideUrlLoading(view, request);
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("yzz", "ur2222===" + url);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://hsfapp.scloudpay.com/static/helpCenter/helpIndex.html");
        webView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.clearCache(true); //清空缓存
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                if (webViewLayout != null) {
                    webViewLayout.removeView(webView);
                }
                webView.removeAllViews();
                webView.destroy();
            } else {
                webView.removeAllViews();
                webView.destroy();
                if (webViewLayout != null) {
                    webViewLayout.removeView(webView);
                }
            }
            webView = null;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                this.finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

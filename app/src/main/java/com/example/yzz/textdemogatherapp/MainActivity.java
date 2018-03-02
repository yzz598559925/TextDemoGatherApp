package com.example.yzz.textdemogatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yzz.textdemogatherapp.builder.Builder;
import com.example.yzz.textdemogatherapp.builder.Computer;
import com.example.yzz.textdemogatherapp.builder.ConcreteBuilder;
import com.example.yzz.textdemogatherapp.builder.Director;
import com.example.yzz.textdemogatherapp.factory.FactoryA;
import com.example.yzz.textdemogatherapp.factory.FactoryB;
import com.example.yzz.textdemogatherapp.proxy.MyJieKou;
import com.example.yzz.textdemogatherapp.proxy.ProxyFactory;
import com.example.yzz.textdemogatherapp.proxy.ProxyObject;
import com.example.yzz.textdemogatherapp.proxy.TargetObject;
import com.example.yzz.textdemogatherapp.review.proxy.MyProxyObject;
import com.example.yzz.textdemogatherapp.review.proxy.MyTargetObject;
import com.example.yzz.textdemogatherapp.review.proxy2.BaseProxyObject;
import com.example.yzz.textdemogatherapp.review.proxy2.BaseTargetObject;
import com.example.yzz.textdemogatherapp.textToolbar.Activity_Text_ToolBar;
import com.example.yzz.textdemogatherapp.utils.CeShiClass;
import com.example.yzz.textdemogatherapp.utils.CheckProxy;
import com.example.yzz.textdemogatherapp.utils.NumberCallBack;
import com.example.yzz.textdemogatherapp.viewpager.Activity_material_viewpager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button pass_toolbar;
    private Button pass_viewpager;
    private Button pass_set_number;
    private Button pass_get_number;
    private String s = null;
    private CheckProxy proxy;
    private Button pass_proxy;
    private Button pass_proxy_dong;
    private Button pass_builder;
    private Button pass_factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        proxy = new CheckProxy(this);
    }

    private void initView() {
        pass_toolbar = (Button) findViewById(R.id.pass_toolbar);
        pass_viewpager = (Button) findViewById(R.id.pass_viewpager);
        pass_set_number = (Button) findViewById(R.id.pass_set_number);
        pass_get_number = (Button) findViewById(R.id.pass_get_number);
        pass_proxy = (Button) findViewById(R.id.pass_proxy);
        pass_proxy.setOnClickListener(this);
        pass_proxy_dong = (Button) findViewById(R.id.pass_proxy_dong);
        pass_proxy_dong.setOnClickListener(this);
        pass_builder = (Button) findViewById(R.id.pass_builder);
        pass_builder.setOnClickListener(this);
        pass_factory = (Button) findViewById(R.id.pass_factory);
        pass_factory.setOnClickListener(this);
        pass_toolbar.setOnClickListener(this);
        pass_viewpager.setOnClickListener(this);
        pass_set_number.setOnClickListener(this);
        pass_get_number.setOnClickListener(this);
    }

    int n = 5;
    boolean b;

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.pass_toolbar:
                intent = new Intent(this, Activity_Text_ToolBar.class);
                startActivity(intent);
                break;
            case R.id.pass_viewpager:
                intent = new Intent(this, Activity_material_viewpager.class);
                intent.putExtra("url", "https://www.baidu.com");
                startActivity(intent);
                break;
            case R.id.pass_set_number:
                Log.i("yzz", "添加数字");
                //n = n + 1;
                CeShiClass.getCeShi().setNumber(new NumberCallBack() {
                    @Override
                    public void GetNumber(int i) {
                        Log.i("yzz", "i===" + i);
                    }

                    @Override
                    public void GetMaXNumber(int max) {
                        Log.i("yzz", "完成");
                    }
                });
                break;
            case R.id.pass_get_number:
                //Log.i("yzz", "proxy===" + proxy.isWifiProxy() + "");
                CeShiClass.getCeShi().set(n = n + 1);
                //b = n > 6;
                //Toast.makeText(MainActivity.this, b + "", Toast.LENGTH_SHORT).show();
                //if (TextUtils.isEmpty(s)) {
                //Toast.makeText(MainActivity.this, "NULLLLL", Toast.LENGTH_SHORT).show();
                //}
                break;
            case R.id.pass_proxy:
//                TargetObject t = new TargetObject();
//                ProxyObject p = new ProxyObject(t);
//                p.Save();
//                MyTargetObject t = new MyTargetObject();
//                MyProxyObject p = new MyProxyObject(t);
//                p.mSuccess();
                BaseTargetObject t = new BaseTargetObject();
                BaseProxyObject p = new BaseProxyObject(t);
                p.getData();
                break;
            case R.id.pass_proxy_dong:
                MyJieKou target = new TargetObject();
                MyJieKou t1 = (MyJieKou) new ProxyFactory(target).getProxyInstance();
                t1.Save();
                break;
            case R.id.pass_builder:
                //逛了很久终于发现一家合适的电脑店
                //找到该店的老板和装机人员
                Director director = new Director();
                Builder builder = new ConcreteBuilder();
                //沟通需求后，老板叫装机人员去装电脑
                director.Construct(builder);
                //装完后，组装人员搬来组装好的电脑
                Computer computer = builder.GetComputer();
                //组装人员展示电脑给小成看
                computer.Show();
                break;
            case R.id.pass_factory:
                FactoryA a = new FactoryA();
                a.Manufacture().Show();
                FactoryB b = new FactoryB();
                b.Manufacture().Show();
                break;
        }
    }
}

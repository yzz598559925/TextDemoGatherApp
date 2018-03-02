package com.example.yzz.textdemogatherapp.textToolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.yzz.textdemogatherapp.R;

/**
 * Created by yzz on 2017/10/18 0018.
 * 测试ToolBar上面的箭头
 */
public class Activity_Text_ToolBar extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_toolbar_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);//用ToolBar来代替ActionBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mToggle.syncState();
        mDrawerLayout.addDrawerListener(mToggle);
    }

}

package com.example.administrator.myapplication;

import android.os.Bundle;

import com.example.administrator.myapplication.base.AbstractPresent;
import com.example.administrator.myapplication.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected AbstractPresent createPresenter() {
        return null;
    }

    @Override
    public void loading() {

    }

    @Override
    public void loadFinish() {

    }
}

package com.example.administrator.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class LoadingDialog extends Dialog {
Context context;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    initView();
    }

    private void initView() {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.loading, null);
        setContentView(view);
        ImageView loading = view.findViewById(R.id.go);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        attributes.width= (int) (d.widthPixels*0.8);
        window.setAttributes(attributes);
    }


}

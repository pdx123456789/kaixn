package com.example.administrator.myapplication.something;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SomeBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"收到广播了",Toast.LENGTH_SHORT).show();
    }
}

package com.example.administrator.myapplication.something;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScreteOpenHelper extends SQLiteOpenHelper{
    public ScreteOpenHelper(Context context) {
        super(context, "sectet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table screte(id integer ,name varchar(20),zhanghao varchar(200),mima integer(20),shijian varchar(20),shuoming varchar(20),dengji integer(10))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

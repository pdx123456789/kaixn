package com.example.administrator.myapplication.something;

import android.database.sqlite.SQLiteDatabase;

import org.junit.Test;

public class PersonalOpenHelperTest {

    @Test
    public void onCreate() {
        ScreteOpenHelper helper = new ScreteOpenHelper(null, "person.db", null, 1);
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();


    }

    @Test
    public void onUpgrade() {
    }
}
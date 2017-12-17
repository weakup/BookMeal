package com.example.lisiyan.bookmeal.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.NetworkInfo;

/**
 * Created by lisiyan on 2017/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String name = "elm"; //数据库名称

    private static final int version = 1; //数据库版本

    private final String CREATETABLE ="CREATE TABLE USER(" +
            "NAME VARCHAR(10),"+
            "PASSWORD VARCHAR(10)"
            +")";



    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATETABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(name);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}

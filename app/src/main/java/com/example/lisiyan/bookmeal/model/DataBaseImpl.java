package com.example.lisiyan.bookmeal.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lisiyan on 2017/12/17.
 */

public class DataBaseImpl {

    private final String TABLE_NAME = "USER";
    private Context mContext;
    private DatabaseHelper mDatabaseHelper;
    private static DataBaseImpl instance = null;

    private DataBaseImpl(Context context){
        this.mContext = context;
        mDatabaseHelper = new DatabaseHelper(context);
    }

    public static synchronized DataBaseImpl newInstance(Context context){

        if (instance==null){

            instance=new DataBaseImpl(context);
            return instance;
        }

        return instance;
    }

    public int insert(String name ,String password){
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("password",password);

        long newRowId=db.insert(TABLE_NAME,null,values);

        return (int) newRowId;
    }

    public boolean query(String name,String password){

        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();

        String[] columns={
                "name",
                "password"
        };

        final String selection =" name = ? and"+
                                " password = ?";

         final String[] selectionArgs ={name,password};



         Cursor cursor = db.query(TABLE_NAME,
                                    columns,
                                    selection,
                                    selectionArgs,
                                    null,null,null);

        return cursor.getCount() != 0;
    }
}

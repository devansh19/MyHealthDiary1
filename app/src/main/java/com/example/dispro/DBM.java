package com.example.dispro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBM extends SQLiteOpenHelper {
    static final String DBName = "APP_Data.db";
    static final int DBVersion = 1;
    static final String DBTable="Userdetails";
    public static final String Name="name";
    public static final String Contact="contact";
    public static final String Dob="dob";
    private static final String DBCreateQuarry = "create Table "+ DBTable+" ( "+Name+" TEXT primary key, " +Contact+" TEXT, "+ Dob+" TEXT)";


    public DBM(Context context) {
        super(context, DBName, null, DBVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(DBCreateQuarry);
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("DROP TABLE IF EXISTS "+DBTable);
    }
    public Boolean insert(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(Contact, contact);
        contentValues.put(Dob, dob);
        long result=DB.insert(DBTable, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean update(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from "+DBTable+" where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update(DBTable, contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean delete (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from "+DBTable+" where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete(DBTable, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor fetch ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from "+DBTable, null);
        return cursor;
    }
}
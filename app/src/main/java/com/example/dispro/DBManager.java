package com.example.dispro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;
    public DBManager(Context ctx) {
        context=ctx;
    }
    public DBManager open() throws SQLDataException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public  void close(){
        dbHelper.close();
    }
    public void insert(String username,String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.UserName, username);
        contentValues.put(DBHelper.UserPass, password);
        database.insert(DBHelper.DBTable,null,contentValues);
    }

    public Cursor fetch(){
        String[] columns = new String[] {DBHelper.UserID,DBHelper.UserName,DBHelper.UserPass};
        Cursor cursor = database.query(DBHelper.DBTable,columns,null,null,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public  int update(long _id,String username,String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.UserName,username);
        contentValues.put(DBHelper.UserPass,password);
        int ret = database.update(DBHelper.DBTable,contentValues,DBHelper.UserID+"="+_id,null);
        return ret;
    }
    public void delete (long _id){
        database.delete(DBHelper.DBTable,DBHelper.UserID+"="+_id,null);
    }
}

package com.example.dispro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DBName = "APP_Data.db";
    static final int DBVersion = 1;
    static final String DBTable="USERS";
    static final String UserID="_ID";
    static final String UserName="User_name";
    static final String UserPass="Password";

    private static final String DBCreateQuarry="CREATE TABLE "+ DBTable+" ( "
            +UserID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ UserID+" TEXT NOT NULL, "+UserPass+" );";

    public DBHelper( Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBCreateQuarry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS "+DBTable);
    }
}

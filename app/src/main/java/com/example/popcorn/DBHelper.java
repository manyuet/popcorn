package com.example.popcorn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CREATE_ACCOUNT_BOOK = "CREATE TABLE ACCOUNT_BOOK("
            + "id  integer PRIMARY KEY Autoincrement ,"
            + "username text,"
            + "tag text ,"
            + "amount real ,"
            + "date date)";

    public static final String CREATE_USER_ACCOUNT = "CREATE TABLE USER_ACCOUNT("
            + "id  integer PRIMARY KEY Autoincrement ,"
            + "username text,"
            + "password text)";

    private Context myContent;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContent = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACCOUNT_BOOK);
        db.execSQL(CREATE_USER_ACCOUNT);
        Toast.makeText(myContent, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

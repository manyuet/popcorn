package com.example.popcorn;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.popcorn.adapter.AccountAdapter;
import com.example.popcorn.entity.Account;

import java.util.LinkedList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private List<Account> mData;
    private AccountAdapter mAdapter;
    private Context mContext;
    private ListView account_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mContext = DetailActivity.this;
        dbHelper = new DBHelper(this,"BookKeeping.db",null,1);
        //获取 SQLiteDatabase 对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // query data
        Cursor cursor = db.query("ACCOUNT_BOOK", null, null, null, null, null, null, null);
        //遍历Curosr对象，取出数据并打印
        mData = new LinkedList<>();
        while (cursor.moveToNext()) {
            Double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            mData.add(new Account(amount,date,null));
        }
        //关闭Cursor
        cursor.close();
        mAdapter = new AccountAdapter((LinkedList<Account>) mData, mContext);
        account_details = findViewById(R.id.account_book_detail);
        account_details.setAdapter(mAdapter);
    }
}

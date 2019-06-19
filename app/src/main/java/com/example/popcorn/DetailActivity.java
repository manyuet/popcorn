package com.example.popcorn;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.popcorn.adapter.AccountAdapter;
import com.example.popcorn.entity.Record;

import java.util.LinkedList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private List<Record> mData;
    private AccountAdapter mAdapter;
    private Context mContext;
    private ListView account_details;
    private EditText etSearch;
    private Button btnSearch;
    private Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //获取数据冲DBUtil的数组里获取
        // 根据登录后的用户的用户名获取属于他的记账记录
        mData = DBUtil.getRecordsByUsername(DBUtil.loginUsername);
        mContext = DetailActivity.this;
        mAdapter = new AccountAdapter((LinkedList<Record>) mData, mContext);
        account_details = findViewById(R.id.lv_account_book_detail);
        account_details.setAdapter(mAdapter);

        etSearch=findViewById(R.id.et_search);
        btnSearch=findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData = DBUtil.getRecordsByUsernameAndTag(DBUtil.loginUsername,etSearch.getText().toString());
                mContext = DetailActivity.this;
                mAdapter = new AccountAdapter((LinkedList<Record>) mData, mContext);
                account_details = findViewById(R.id.lv_account_book_detail);
                account_details.setAdapter(mAdapter);
            }
        });
        btnReset=findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData = DBUtil.getRecordsByUsername(DBUtil.loginUsername);
                mContext = DetailActivity.this;
                mAdapter = new AccountAdapter((LinkedList<Record>) mData, mContext);
                account_details = findViewById(R.id.lv_account_book_detail);
                account_details.setAdapter(mAdapter);
                etSearch.setText("");
            }
        });
    }
}


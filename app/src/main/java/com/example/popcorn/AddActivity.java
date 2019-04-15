package com.example.popcorn;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    private Button btnAdd;
    private Button btnCancel;
    private EditText etAmount;
    private EditText etDate;
    private RadioGroup rbtnTag;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbHelper = new DBHelper(this,"BookKeeping.db",null,1);
        initView();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Double amount = Double.valueOf(etAmount.getText().toString());
                Date date = new Date();
                //获取 SQLiteDatabase 对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //使用ContentValues 对数据进行组装
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("amount", amount);
                values.put("date", String.valueOf(date));
                db.insert("ACCOUNT_BOOK", null, values);
                Log.d("db", "insert success");




            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        btnAdd = findViewById(R.id.btn_add);
        btnCancel = findViewById(R.id.btn_cancel);
        etAmount = findViewById(R.id.et_amount);
        etDate = findViewById(R.id.et_date);
        rbtnTag = findViewById(R.id.radioGroup);
    }

    public void showToast(View view){
        Toast.makeText(this,"add successfully",Toast.LENGTH_SHORT).show();
    }
}

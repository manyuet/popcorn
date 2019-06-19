package com.example.popcorn;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.popcorn.entity.Record;

import java.util.Date;

public class AddActivity extends AppCompatActivity {
    private Button btnAdd;
    private Button btnCancel;
    private EditText etAmount;

    private EditText etTag;
    private CalendarView calendarView;
    private String time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Double amount = Double.valueOf(etAmount.getText().toString());
                String tag = String.valueOf(etTag.getText().toString());
                // 在点击添加按钮的时候，根据填写的数据，组装成record对象，调用addRecord方法，将record对象存进records里
                Record record = new Record();
                record.setAmount(amount);
                record.setTime(time);
                record.setTag(tag);
                // 这里就拿到登录后的用户名了
                record.setUsername(DBUtil.loginUsername);
                // 将组装好的record对象，通过addRecord方法存进去
                DBUtil.addRecord(record);
                Log.d("db", "insert success");
                Toast.makeText(AddActivity.this, "add successful", Toast.LENGTH_SHORT).show();


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                time = year+"-"+month+"-"+dayOfMonth;
            };
        });
    }

    private void initView() {
        btnAdd = findViewById(R.id.btn_add);
        btnCancel = findViewById(R.id.btn_cancel);
        etAmount = findViewById(R.id.et_amount);
        etTag = findViewById(R.id.et_tag);
        calendarView = findViewById(R.id.cal_view);


    }

    public void showToast(View view){
        Toast.makeText(this,"add successfully",Toast.LENGTH_SHORT).show();
    }
}

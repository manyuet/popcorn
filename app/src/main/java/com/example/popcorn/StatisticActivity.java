package com.example.popcorn;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.popcorn.adapter.AccountAdapter;
import com.example.popcorn.adapter.StatisticAdapter;
import com.example.popcorn.entity.Record;
import com.example.popcorn.entity.StatisticRecord;

import java.util.LinkedList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private List<StatisticRecord> mData;
    private StatisticAdapter mAdapter;
    private Context mContext;
    private ListView statistic_details;
    private EditText etSearch;
    private Button btnSearch;
    private Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        mData = DBUtil.countAllTagAmount(DBUtil.loginUsername);
        mContext = StatisticActivity.this;
        mAdapter = new StatisticAdapter(mData, mContext);
        statistic_details = findViewById(R.id.lv_statistic_detail);
        statistic_details.setAdapter(mAdapter);
    }
}


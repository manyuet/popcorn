package com.example.popcorn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.popcorn.R;
import com.example.popcorn.entity.Record;
import com.example.popcorn.entity.StatisticRecord;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StatisticAdapter extends BaseAdapter {

    private List<StatisticRecord> mData;
    private Context mContext;

    public StatisticAdapter(List<StatisticRecord> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_statistic_detail,parent,false);
        TextView tv_amount = (TextView) convertView.findViewById(R.id.tv_statistic_amount);
        tv_amount.setText(mData.get(position).getAmount().toString());
        TextView tv_tag = (TextView) convertView.findViewById(R.id.tv_statistic_tag);
        tv_tag.setText(mData.get(position).getTag().toString());
        return convertView;
    }
}

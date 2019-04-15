package com.example.popcorn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.popcorn.R;
import com.example.popcorn.entity.Account;

import java.util.LinkedList;

public class AccountAdapter extends BaseAdapter {

    private LinkedList<Account> mData;
    private Context mContext;

    public AccountAdapter(LinkedList<Account> mData, Context mContext) {
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
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_activity_detail,parent,false);
        TextView tv_amount = (TextView) convertView.findViewById(R.id.tv_amount);
        tv_amount.setText(mData.get(position).getAmount().toString());
        TextView tv_date = (TextView) convertView.findViewById(R.id.tv_date);
        tv_date.setText(mData.get(position).getDate().toString());
        return convertView;
    }
}

package com.example.popcorn.entity;

import java.sql.Date;

public class Account {
    private Double amount;
    private String date;
    private String tag;

    public Account(Double amount, String date, String tag) {
        this.amount = amount;
        this.date = date;
        this.tag = tag;
    }

    public Account(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

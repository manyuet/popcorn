package com.example.popcorn.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Record {
    private String tag;
    private Double amount;
    private String username;
    private String time;


    public Record(String tag, Double amount, String username, String time) {
        this.tag = tag;
        this.amount = amount;
        this.username = username;
        this.time = time;

    }

    public Record() {

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

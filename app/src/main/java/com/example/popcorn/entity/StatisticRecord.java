package com.example.popcorn.entity;

public class StatisticRecord {
    private String tag;
    private Double amount;

    public StatisticRecord() {
    }

    public StatisticRecord(String tag, Double amount) {
        this.tag = tag;
        this.amount = amount;
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
}

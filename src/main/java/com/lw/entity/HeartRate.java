package com.lw.entity;

import java.util.Date;

public class HeartRate {
    private Integer id;

    private Integer userId;

    private Date dateTime;

    private Integer rate;
    
    public HeartRate(Integer userId, Date dateTime, Integer rate) {
      super();
      this.userId = userId;
      this.dateTime = dateTime;
      this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
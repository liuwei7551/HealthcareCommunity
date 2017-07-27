package com.lw.dto;

import java.util.Date;

public class HeartRateDto {
  private Date dateTime;

  private Integer rate;

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

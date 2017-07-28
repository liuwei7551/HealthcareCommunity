package com.lw.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
  
  public static Date getDateBefore(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);//把当前时间赋给日历
    calendar.add(Calendar.DAY_OF_YEAR, -1);
    Date dateBefore = calendar.getTime();
    return dateBefore;
  }
}

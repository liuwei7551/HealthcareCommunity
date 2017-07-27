package com.lw.endpoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.common.utils.DateUtils;
import com.lw.dto.ResponseDto;
import com.lw.entity.HeartRate;
import com.lw.service.HeartRateService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
public class Test {
  
  @Autowired
  private HeartRateService heartRateService;
  
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/heartRate/batchInsert" }, method = RequestMethod.GET)
  public ResponseDto<?> insertHeartRate() throws ParseException{
    Random random = new Random();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = simpleDateFormat.parse("2017-07-27 00:00:00");
    int userId = 1;
    List<HeartRate> heartRates = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      heartRates.add(new HeartRate(userId, date, 65 + random.nextInt(20)));
      date = DateUtils.getDateBefore(date);
    }
    heartRateService.bachInsert(heartRates);
    return ResponseDto.OK;
  }
  
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/heartRate/insert" }, method = RequestMethod.GET)
  public ResponseDto<?> add() throws ParseException{
    Random random = new Random();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = simpleDateFormat.parse("2017-07-27 00:00:00");
    int userId = 1;
    HeartRate heartRate = new HeartRate(userId, date, 65 + random.nextInt(20));
    heartRate.setId(1);
    heartRateService.insert(heartRate);
    return ResponseDto.OK;
  }
  
  
  @ApiOperation(value = "获取表格所需数据")
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/test/data" }, method = RequestMethod.GET)
  public List<Data> getData() {
    List<Data> list = new ArrayList<>();
    list.add(new Data("data1", 1));
    list.add(new Data("data2", 2));
    list.add(new Data("data3", 3));
    list.add(new Data("data4", 4));
    list.add(new Data("data5", 5));
    return list;
  }
  
  class Data{
    String name;
    int value;
    
    public Data(String name, int value) {
      super();
      this.name = name;
      this.value = value;
    }
    
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getValue() {
      return value;
    }
    public void setValue(int value) {
      this.value = value;
    }
    
  }
}

package com.lw.endpoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.lw.dto.HeartRateDto;
import com.lw.dto.ResponseDto;
import com.lw.entity.HeartRate;
import com.lw.service.HeartRateService;

@CrossOrigin
@Controller
public class HeartRateEndpoint {

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
  @RequestMapping(value = { "api/v1/heartRate" }, method = RequestMethod.GET)
  public ResponseDto<List<HeartRateDto>> getHeartRates() throws ParseException{
    ResponseDto<List<HeartRateDto>> responseDto = new ResponseDto<>();
    responseDto.setData(heartRateService.select());
    return responseDto;
  }
  
}

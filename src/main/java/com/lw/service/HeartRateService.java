package com.lw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.dao.HeartRateMapper;
import com.lw.dto.HeartRateDto;
import com.lw.entity.HeartRate;

@Service
public class HeartRateService {
  @Autowired
  private HeartRateMapper heartRateMapper;
  
  public void bachInsert(List<HeartRate> heartRates) {
    heartRateMapper.batchInsert(heartRates);
  }
  
  public void insert(HeartRate heartRate) {
    heartRateMapper.insert(heartRate);
  }
  
  public List<HeartRateDto> select() {
    return heartRateMapper.select();
  }
}

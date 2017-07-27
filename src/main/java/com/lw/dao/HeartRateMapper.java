package com.lw.dao;

import java.util.List;

import com.lw.dto.HeartRateDto;
import com.lw.entity.HeartRate;

public interface HeartRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HeartRate record);

    int insertSelective(HeartRate record);

    HeartRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeartRate record);

    int updateByPrimaryKey(HeartRate record);
    
    int batchInsert(List<HeartRate> heartRates);
    
    List<HeartRateDto> select();
}
package com.lw.dao;

import com.lw.entity.HeartRate;

public interface HeartRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HeartRate record);

    int insertSelective(HeartRate record);

    HeartRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeartRate record);

    int updateByPrimaryKey(HeartRate record);
}
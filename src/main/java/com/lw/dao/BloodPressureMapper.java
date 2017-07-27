package com.lw.dao;

import com.lw.entity.BloodPressure;

public interface BloodPressureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BloodPressure record);

    int insertSelective(BloodPressure record);

    BloodPressure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BloodPressure record);

    int updateByPrimaryKey(BloodPressure record);
}
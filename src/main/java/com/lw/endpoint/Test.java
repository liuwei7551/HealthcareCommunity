package com.lw.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
public class Test {

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

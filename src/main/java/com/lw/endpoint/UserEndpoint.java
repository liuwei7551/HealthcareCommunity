package com.lw.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.dto.ResponseDto;
import com.lw.entity.User;
import com.lw.entity.User1;
import com.lw.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
public class UserEndpoint {

  @Resource
  private UserService userService;

  @ApiOperation(value = "获取用户信息")
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/user/{userId}" }, method = RequestMethod.GET)
  public List<User1> getUser(@PathVariable final int userId) {
//    return ResponseDto.create(userService.getUserById(userId));
    List<User1> users = new ArrayList<>();
    users.add(new User1("aaa", "bbb"));
    users.add(new User1("11", "22"));
    return users;
  }
  
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/user" }, method = RequestMethod.GET)
  public List<User> userList() {
    return userService.getUsers();
  }
  
  @ResponseBody
  @RequestMapping(value = { "api/v1/user/load" }, method = RequestMethod.GET)
  public ResponseDto<?> load() {
    System.out.println("name is "+ "aa");
    System.out.println("age is "+ 12);
    return ResponseDto.create("aa" +" is "+ 12 + "years old");
  }
  
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/user/login" }, method = RequestMethod.POST)
  public User1 getUser(User1 user) {
    System.out.println(user.getUserName());
    return user;
  }
  
  @ResponseBody // 将Java对象输出json
  @RequestMapping(value = { "api/v1/user/checkUserName" }, method = RequestMethod.GET)
  public ResponseDto<?> checkUserName(final String userName) {
    ResponseDto<?> responseDto = ResponseDto.OK;
    if(userName.equals("lw")){
      responseDto.setResponseCode("001");
    }
    return responseDto;
  }
}

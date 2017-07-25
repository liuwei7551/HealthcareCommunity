package com.lw.entity;

public class User1 {
  public String userName;
  public String pwd;
  
  public User1() {
    super();
  }
  public User1(String userName, String pwd) {
    super();
    this.userName = userName;
    this.pwd = pwd;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  
}

package com.eomcs.lms.domain;

import java.sql.Date;

public class Member {

  private int no;
  private String Name;
  private String email;
  private String pw;
  private String pic;
  private String phoneNum;
  private Date signedUpDate;
  
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return Name;
  }
  public void setName(String Name) {
    this.Name = Name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPw() {
    return pw;
  }
  public void setPw(String pw) {
    this.pw = pw;
  }
  public String getPic() {
    return pic;
  }
  public void setPic(String pic) {
    this.pic = pic;
  }
  public String getPhoneNum() {
    return phoneNum;
  }
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }
  public Date getSignedUpDate() {
    return signedUpDate;
  }
  public void setSignedUpDate(Date signedUpDate) {
    this.signedUpDate = signedUpDate;
  }
  
  
  
}

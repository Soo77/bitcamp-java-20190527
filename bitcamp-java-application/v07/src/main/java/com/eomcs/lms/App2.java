package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  static Scanner keyScan;
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);

    Member[] members = new Member[100];

    
    int i=0;
    for( ; i < members.length; i++) {
      Member member = new Member();
      
      member.no = getIntValue("번호 ?");
      member.lectureName = getStringValue("이름? ");
      member.email = getStringValue("이메일? ");
      member.pw = getStringValue("암호? ");
      member.pic = getStringValue("사진? ");
      member.phoneNum = getStringValue("전화? ");
      member.signedUpDate = getDateValue("가입일? ");
      
      members[i] = member;
      
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyScan.nextLine();
      if (response.equals("n")) {
        break;
      }
    }
    
    
    System.out.println();
    
    int i2=0;
    for ( ; i2 <= i; i2++){
      Member member = members[i2];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", 
          member.no, member.lectureName, member.email, member.pw, 
          member.pic, member.phoneNum, member.signedUpDate);
    }
  }
  
  
  private static int getIntValue(String msg) {
    while(true) {
      try {
        System.out.print(msg);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }
  
  private static java.sql.Date getDateValue(String msg) {
    while(true) {
      try {
        System.out.print(msg);
        return java.sql.Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }
  
  private static String getStringValue(String msg) {
    while(true) {
      try {
        System.out.print(msg);
        return keyScan.nextLine();
      } catch (NumberFormatException e) {
        System.out.println("잘못입력하셨습니다.");
      }
    }
  }

}

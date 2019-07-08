package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  static Scanner keyScan;
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);

    
    int[] no = new int[100];
    String[] lectureName = new String[100];
    String[] email = new String[100];
    String[] pw = new String[100];
    String[] pic = new String[100];
    String[] phoneNum = new String[100];
    Date[] signedUpDate = new Date[100];
    
    int i=0;
    
    while(true) {
      no[i] = getIntValue("번호 ?");
      lectureName[i] = getStringValue("이름? ");
      email[i] = getStringValue("이메일? ");
      pw[i] = getStringValue("암호? ");
      pic[i] = getStringValue("사진? ");
      phoneNum[i] = getStringValue("전화? ");
      signedUpDate[i] = getDateValue("가입일? ");
      i++;
      
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyScan.nextLine();
      if (response.equals("n")) {
        break;
      }
    }
    
    
    System.out.println();
    
    int i2=0;
    while(i2 < i) {
      System.out.printf("%s, %s, %s ~ %s, %s, %s\n", 
          no[i2], lectureName[i2], email[i2], pw[i2], pic[i2], phoneNum[i2], signedUpDate[i2]);
      i2++;
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

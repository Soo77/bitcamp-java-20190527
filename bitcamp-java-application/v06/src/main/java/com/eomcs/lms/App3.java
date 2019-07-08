package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  static Scanner keyScan;
  
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);


    int[] no = new int[100];
    String[] name = new String[100];
    Date[] writeDate = new Date[100];
    int[] viewNum = new int[100];

    int i=0;
    
    while(true) {
      no[i] = getIntValue("번호 ?");
      name[i] = getStringValue("내용? ");
      writeDate[i] = getDateValue("작성일? ");
      viewNum[i] = getIntValue("조회수? ");
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
      System.out.printf("%s, %s, %s, %s\n", 
          no[i2], name[i2], writeDate[i2], viewNum[i2]);
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

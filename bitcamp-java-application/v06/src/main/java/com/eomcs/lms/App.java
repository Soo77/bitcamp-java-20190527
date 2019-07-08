// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
  static Scanner keyScan;
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);
    
    int[] no = new int[100];
    String[] lectureName = new String[100];
    String[] description = new String[100];
    Date[] startDate = new Date[100];
    Date[] endDate = new Date[100];
    int[] totalHours = new int[100];
    int[] dayHours = new int[100];
    
    int i=0;
    
    while(true) {
      no[i] = getIntValue("번호 ?");
      lectureName[i] = getStringValue("수업명? ");
      description[i] = getStringValue("설명? ");
      startDate[i] = getDateValue("시작일? ");
      endDate[i] = getDateValue("종료일? ");
      totalHours[i] = getIntValue("총 수업시간? ");
      dayHours[i] = getIntValue("일 수업시간? ");
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
          no[i2], lectureName[i2], description[i2], startDate[i2], endDate[i2], totalHours[i2], dayHours[i2]);
      i2++;
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
  
  private static Date getDateValue(String msg) {
    while(true) {
      try {
        System.out.print(msg);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }
  
  

}

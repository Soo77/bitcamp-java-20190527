// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.util.Scanner;

public class App {
  
  static Scanner keyScan;
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);
    
    
    int no = getIntValue("번호 ?");
    String lectureName = getStringValue("수업명? ");
    String description = getStringValue("설명? ");
    java.sql.Date startDate = getDateValue("시작일? ");
    java.sql.Date endDate = getDateValue("종료일? ");
    int totalHours = getIntValue("총 수업시간? ");
    int dayHours = getIntValue("일 수업시간? ");
    
    
    System.out.println();
    
    System.out.printf("번호: %s\n", no);
    System.out.printf("수업명: %s\n", lectureName);
    System.out.printf("설명: %s\n", description);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n",  endDate);
    System.out.printf("총수업시간: %s\n", totalHours);
    System.out.printf("일수업시간: %s\n", dayHours);
  }
  
  
  
  private static String getStringValue(String msg) {
    System.out.println(msg);
    return keyScan.nextLine();
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
  
  

}

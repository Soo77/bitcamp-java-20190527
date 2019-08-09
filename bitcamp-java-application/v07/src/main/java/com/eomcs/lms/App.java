// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
  static Scanner keyScan;
  
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    Lesson[] lessons = new Lesson[100];
    
    int i = 0;
    for ( ; i < lessons.length; i++) {
      
      // 수업 데이터를 저장할 메모리를 Lesson 설계도에 따라 만든다.
      Lesson lesson = new Lesson();
      
      // 사용자가 입력한 값을 Lesson 인스턴스의 각 변수에 저장한다.
      lesson.no = getIntValue("번호? ");
      lesson.title = getStringValue("수업명? ");
      lesson.contents = getStringValue("설명? ");
      lesson.startDate = getDateValue("시작일? ");
      lesson.endDate = getDateValue("종료일? ");
      lesson.totalHours = getIntValue("총수업시간? ");
      lesson.dayHours = getIntValue("일수업시간? ");
      
      // 수업 데이터를 저장하고 있는 인스턴스의 주소를 레퍼런스 배열에 저장한다.
      lessons[i] = lesson;
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyScan.nextLine();
      
      if (response.equals("n"))
        break;
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
      
      // 레퍼런스 배열에서 한 개의 인스턴스 주소를 꺼낸다.
      Lesson lesson = lessons[i2];
      
      // 그 인스턴스 주소로 찾아가서 인스턴스의 각 변수 값을 꺼내 출력한다.
      System.out.printf("%s, %s, %s ~ %s, %s\n", 
          lesson.no, lesson.title, 
          lesson.startDate, lesson.endDate, lesson.totalHours);
    }
  }
  
  private static int getIntValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }
  
  private static Date getDateValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }
  
  private static String getStringValue(String message) {
    System.out.print(message);
    return keyScan.nextLine();
  }
}











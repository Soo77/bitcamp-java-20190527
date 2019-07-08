// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
  static Scanner keyScan;
  
  static Lesson[] lessons = new Lesson[100];
  static int lessonsSize = 0;

  static Member[] members = new Member[100];
  static int membersSize = 0;
  
  static Board[] boards = new Board[100];
  static int boardsSize = 0;
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);
    
    
    

    
    while (true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();
      if (command.equals("quit")) {
        break;
      } else if (command.equals("/lesson/add")) {// 참이라면 add를 else면 그밖의 것 실행
        addLesson();// addLesson() 메서드 블록에 묶어 놓은 코드를 실행한다.
        
      } else if (command.equals("/lesson/list")) {
        listLesson();
        
      } else if (command.equals("/member/add")) {
        addMember();
        
      } else if (command.equals("/member/list")) {
        listMember();
        
      } else if (command.equals("/board/add")) {
        addBoard();
        
      } else if(command.equals("/board/list")) {
        listBoard();
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    System.out.println();
    System.out.println();
  }





  private static void listBoard() {
    for(int i=0; i < boardsSize; i++) {
      Board board = boards[i];
      System.out.printf("%s, %s, %s\n\n", 
          board.no, board.contents, board.createdDate);
    }
  }





  private static void addBoard() {
    Board board = new Board();
    
    board.no = getIntValue("번호 ?");
    board.contents = getStringValue("내용? ");
    board.createdDate = new Date(System.currentTimeMillis());
    
    boards[boardsSize++] = board;
    System.out.println("저장하였습니다.");
  }





  private static void listMember() {
    for (int i=0; i < membersSize; i++){
      Member member = members[i];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n\n", 
          member.no, member.lectureName, member.email, member.pw, 
          member.pic, member.phoneNum, member.signedUpDate);
    }
  }





  private static void addMember() {
    Member member = new Member();
    
    member.no = getIntValue("번호 ?");
    member.lectureName = getStringValue("이름? ");
    member.email = getStringValue("이메일? ");
    member.pw = getStringValue("암호? ");
    member.pic = getStringValue("사진? ");
    member.phoneNum = getStringValue("전화? ");
    member.signedUpDate = getDateValue("가입일? ");
    
    members[membersSize++] = member;
    System.out.println("저장하였습니다.");
  }



  

  private static void addLesson() {
 // 수업 데이터를 저장할 메모리를 Lesson 설계도에 따라 만든다.
    Lesson lesson = new Lesson();
    // 사용자가 입력한 값을 Lesson 인스턴스의 각 변수에 저장한다.
    lesson.no = getIntValue("번호 ?");
    lesson.title = getStringValue("수업명? ");
    lesson.contents = getStringValue("설명? ");
    lesson.startDate = getDateValue("시작일? ");
    lesson.endDate = getDateValue("종료일? ");
    lesson.totalHours = getIntValue("총 수업시간? ");
    lesson.dayHours = getIntValue("일 수업시간? ");

    // 수업 데이터를 저장하고 있는 인스턴스의 주소를 레퍼런스 배열에 저장한다.
    lessons[lessonsSize++] = lesson;
    
    System.out.println("저장하였습니다.");
  }
  
  private static void listLesson() {
    for (int i = 0; i < lessonsSize; i++) {
      Lesson lesson = lessons[i];
      System.out.printf("%s, %s, %s ~ %s, %s, %s\n\n", lesson.no, lesson.title, lesson.contents,
          lesson.startDate, lesson.endDate, lesson.totalHours, lesson.dayHours);
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

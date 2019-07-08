// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.util.Scanner;

public class App {
  
  static Scanner keyScan;

  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);
    Input.keyScan = keyScan;
    LessonHandler.keyScan = keyScan;
    MemberHandler.keyScan = keyScan;
    BoardHandler.keyScan = keyScan;
    
    while (true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();
      if (command.equals("quit")) {
        break;
      } else if (command.equals("/lesson/add")) {// 참이라면 add를 else면 그밖의 것 실행
        LessonHandler.addLesson();// addLesson() 메서드 블록에 묶어 놓은 코드를 실행한다.
        
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
        
      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
        
      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();
        
      } else if(command.equals("/board/list")) {
        BoardHandler.listBoard();
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    System.out.println();
  }
}

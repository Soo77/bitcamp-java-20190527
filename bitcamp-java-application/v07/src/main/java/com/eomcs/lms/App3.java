package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  static Scanner keyScan;
  
  
  public static void main(String[] args) {
    keyScan = new Scanner(System.in);

    Board[] boards = new Board[100];
   
    int i=0;
    for( ; i < boards.length; i++) {
      Board board = new Board();
      
      board.no = getIntValue("번호 ?");
      board.contents = getStringValue("내용? ");
      board.createdDate = new Date(System.currentTimeMillis());
      board.viewCount = getIntValue("조회수? ");

      boards[i] = board;
      
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String response = keyScan.nextLine();
      if (response.equals("n")) {
        break;
      }
    }

    System.out.println();
    
    int i2=0;
    for( ; i2 <= i; i2++) {
      Board board = boards[i2];
      System.out.printf("%s, %s, %s, %s\n", 
          board.no, board.contents, board.createdDate, board.viewCount);
    }
  }

    

  private static int getIntValue(String msg) {
    while (true) {
      try {
        System.out.print(msg);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }

  private static java.sql.Date getDateValue(String msg) {
    while (true) {
      try {
        System.out.print(msg);
        return java.sql.Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }

  private static String getStringValue(String msg) {
    while (true) {
      try {
        System.out.print(msg);
        return keyScan.nextLine();
      } catch (NumberFormatException e) {
        System.out.println("잘못입력하셨습니다.");
      }
    }
  }
}

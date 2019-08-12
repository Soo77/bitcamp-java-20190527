package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class mine {

  public static void main(String[] args) {
    String no = null;
    String title = null;
    String contents = null;
    
    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyboard.nextLine();
      
      System.out.print("제목? ");
      title = keyboard.nextLine();
      
      System.out.print("내용? ");
      contents = keyboard.nextLine();
    }
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      try (Statement stmt = con.createStatement()) {
        
        int count = stmt.executeUpdate(
            "update x_board set title = '" + title + "', contents = '" + contents + "'" 
        + " where board_id = " + no);
        
        
        
        if (count == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        } else {
          System.out.println("삭제하였습니다.");
        }
        
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
}


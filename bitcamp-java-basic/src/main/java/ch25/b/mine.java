package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class mine {

  public static void main(String[] args) {
    String title = null;
    String contents = null;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("제목? ");
      title = scanner.nextLine();

      System.out.println("내용? ");
      contents = scanner.nextLine();

      System.out.println("입력하시겠습니까?(Y/n)");
      String input = scanner.nextLine();

      if (!input.equalsIgnoreCase("y") &&
          input.length() != 0) {
        System.out.println("등록을 취소하였습니다.");
        return;
      }
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      try (Statement stmt = con.createStatement()) {

        stmt.executeUpdate(
            "insert into x_board(title,contents)"
                + " values('" + title + "','" + contents + "')"); 


        System.out.println("등록하였습니다.");
      } 

    } catch (Exception e) {
      
    }
  }
}


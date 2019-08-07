package ch23.mine;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

  public static void main(String[] args) throws Exception {

    try (Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
        

      System.out.println("서버와 연결되었음!");

      System.out.println("서버에 데이터를 보내기 전에 잠깐!");
      keyboard.nextLine();
      
      out.println("hello!");
      out.flush();
      
      
      System.out.println("서버에 데이터를 보냈음!");
      String response = in.nextLine();
      System.out.println(response+"이것");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}


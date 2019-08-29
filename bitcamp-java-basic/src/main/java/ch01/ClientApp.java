package ch01;
// Enter 치면 출력 안되게.
// 서버로 옮기기
// 파일보내기
// userName변경
// 귓속말
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  String host;
  String userName;
  int port;
  Socket socket;
  BufferedReader in;
  PrintStream out;
  Scanner keyboard;

  private void service() {

    keyboard = new Scanner(System.in);

    System.out.print("Server>> ");
    host = keyboard.nextLine();

    System.out.print("Port>> ");
    port = Integer.parseInt(keyboard.nextLine());

    System.out.print("Setting your name>> ");
    userName = keyboard.nextLine();
    try {
      socket = new Socket(host, port);
      out = new PrintStream(socket.getOutputStream());
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      System.out.println("<<Connect with Server>>");
      out.println("[" + userName + "]" + " join");
      while (true) {
        new Thread(new MessageReceiver()).start();
        System.out.print(">> ");
        String message = keyboard.nextLine();
        if (message.equals("/quit")) {
          out.println("[" + userName + "]" + " has left");
          out.println("/quit");
          break;
        }
        out.println(userName + ":" + message);
      }
      
    } catch (Exception e) {
      System.out.println("<<Connect Error with Server>>");
    }
  }

  class MessageReceiver implements Runnable {
    @Override
    public void run() {
      try {
        while (true) {
          String message = in.readLine();
          if (!message.contains(userName)) {
            System.out.println(message);
          }
        }
      } catch (Exception e) {
        // /quit했을시 여러번 출력됨 ㅠㅠㅠ 고치자
//        System.out.println("메세지 수신중 오류 발생");
      }
    }
  }

//  public void sendMessage(String message) {
//    message = keyboard.nextLine();
//    out.println(message);
//  }

  public static void main(String[] args) {
    ClientApp app = new ClientApp();
    app.service();
  }
}

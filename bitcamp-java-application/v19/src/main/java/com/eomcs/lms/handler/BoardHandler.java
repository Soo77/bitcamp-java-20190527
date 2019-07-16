package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class BoardHandler {

  private ArrayList<Board> boardList = new ArrayList<>();
  private Input input;
  
  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  // "의존 객체(dependency)"라 부른다.
  // => 의존 객체를 강제로 설정하게 만드는 방법?
  //    다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public BoardHandler(Input input) {
    this.input = input;
  }
  
  
  public void listBoard() {
    Board[] boards = new Board[boardList.size()]; // 정확한 크기의 배열을 만듦
    boardList.toArray(boards);
    
//    Board[] boards = boardList.toArray(new Board[] {}); // 배열크기 주지 않음.
    for(Board board : boards) {
      System.out.printf("%s, %s \t, %s, %s\n", 
          board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
    }    
  }

  public void addBoard() {
    Board board = new Board();
    
    board.setNo(input.getIntValue("번호 ?"));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    
    boardList.add(board);
    System.out.println("저장하였습니다.");
  }


  public void detailBoard() {
    int no = input.getIntValue("번호 ?");
    
    // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체를 찾는다.
    Board board = null;
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break; 
      }
    }
    
    if (board == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; // 함수 리턴타입이 void라면 함수를 끝내고싶을때 그냥 return하면 됨.
    }
    
    // null이 아니면 데이터를 찾았다는 것이기 떄문에 찾은 데이터를 프린트해준다.
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  }


  public void updateBoard() {
    int no = input.getIntValue("번호 ?");
    
    // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체를 찾는다.
    Board board = null;
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break; 
      }
    }
    
    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return; // 함수 리턴타입이 void라면 함수를 끝내고싶을때 그냥 return하면 됨.
    }
    
    String str = input.getStringValue("내용(" + board.getContents() + ")? ");
    if (str.length() > 0) {
      board.setContents(str);
    }

    System.out.println("게시글을 변경하였습니다.");
  }


  public void deleteBoard() {
    int no = input.getIntValue("번호 ?");
    
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        boardList.remove(i);
        System.out.println("게시글을 삭제하였습니다.");
        return; 
      }
    }
      System.out.println("해당 게시글을 찾을 수 없습니다.");
  }
  
  
}

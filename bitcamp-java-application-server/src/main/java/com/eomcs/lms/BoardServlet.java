package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;

// 게시물 요청을 처리하는 담당자
public class BoardServlet implements Servlet {
  
  ArrayList<Board> boardList = new ArrayList<>();
  
  ObjectInputStream in;
  ObjectOutputStream out;
  
  public BoardServlet(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }
  
  
  @Override
  public void service(String command) throws Exception {
    switch (command) {
      case "/board/add":
        // 클라이언트가 보낸 객체를 읽는다.
        addBoard();
        break;
      case "/board/list":
        listBoard();
        break;
      case "/board/delete":
        deleteBoard();
        break;
      case "/board/detail":
        detailBoard();
        break;
      case "/board/update":
        updateBoard();
        break;
      default:
        out.writeUTF("fail");
        out.writeUTF("지원하지 않는 명령입니다.");
    }
  }
  private void updateBoard() throws Exception {
    Board board = (Board)in.readObject();

    int index = indexOfBoard(board.getNo());
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    boardList.set(index, board);
    out.writeUTF("ok");

  }

  private void detailBoard() throws Exception {
    int no = in.readInt();

    int index = indexOfBoard(no);
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    out.writeUTF("ok");
    out.writeObject(boardList.get(index));

  }


  private void deleteBoard() throws Exception {
    int no = in.readInt();

    int index = indexOfBoard(no);
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    boardList.remove(index);
    out.writeUTF("ok");
   }

  private void addBoard() throws Exception {
    Board board = (Board)in.readObject();
    out.writeUTF("ok");
    boardList.add(board);
  }

  private void listBoard() throws Exception {
    out.writeUTF("ok");
    out.reset(); // 기존에 serialize 했던 객체의 상태를 무시하고 다시 serialize한다.
    out.writeObject(boardList);
  }

  private int indexOfBoard(int no) {
    int i = 0;
    for (Board m : boardList) {
      if (m.getNo() == no) {
        return i;
      }
      i++;
    }
    return -1;
  }  
  
  private void fail(String cause) throws Exception {
    out.writeUTF("fail");
    out.writeUTF(cause);
  }

}

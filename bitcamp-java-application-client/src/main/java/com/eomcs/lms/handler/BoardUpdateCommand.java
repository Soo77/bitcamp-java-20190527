package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;

public class BoardUpdateCommand implements Command {

  private BoardDao boardDao;
  private Input input;

  public BoardUpdateCommand(Input input, BoardDao boardDao) {
    this.input = input;
    this.boardDao = boardDao;
  }

  public void execute() {
    int no = input.getIntValue("번호? ");

    // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Board 객체를 찾는다.

    try {
      Board board = boardDao.findBy(no);
      if (board == null) {
        System.out.println("해당 번호의 데이터가 없습니다!");
        return;
      }

      // 사용자로부터 변경할 값을 입력 받는다.
      String str = input.getStringValue("내용? ");
      if (str.length() > 0) {
        board.setContents(str);
      }
      
      boardDao.update(board);
      
      System.out.println("데이터를 변경하였습니다.");


    } catch (Exception e) {
      System.out.println("데이터 변경에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
}

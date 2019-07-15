package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  static final int DEFAULT_CAPACITY = 100;
  private Board[] list ;
  private int size = 0;
  
  public BoardList() {
    this(DEFAULT_CAPACITY); // 생성자에서 다른 생성자를 호출할수있다.
  }
  
  public BoardList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity > 10000) {
      list = new Board[DEFAULT_CAPACITY]; // 기본사이즈 갖게 하기 안전장치 마련.
    } else {
      list = new Board[initialCapacity];
    }
  }
  
  public void add(Board board) {
    if (this.size == list.length) {
      throw new RuntimeException("배열이 꽉 찼습니다.");
    }
    //this(100); // 컴파일 오류! 일반 메서드는 생성자를 호출할 수 없다.
    this.list[this.size++] = board;
  }
  
  public Board[] toArray() {
    Board[] arr = new Board[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
}

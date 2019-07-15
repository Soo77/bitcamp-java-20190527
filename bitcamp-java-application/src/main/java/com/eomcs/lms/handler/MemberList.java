package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int DEFAULT_CAPACITY = 100;
  private Member[] list = new Member[100];
  private int size = 0;

  
  public MemberList() {
    this(DEFAULT_CAPACITY); // 생성자에서 다른 생성자를 호출할수있다.
  }
  
  public MemberList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity > 10000) {
      list = new Member[DEFAULT_CAPACITY]; // 기본사이즈 갖게 하기 안전장치 마련.
    } else {
      list = new Member[initialCapacity];
    }
  }
  
  public void add(Member member) {
    this.list[this.size++] = member;
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
}

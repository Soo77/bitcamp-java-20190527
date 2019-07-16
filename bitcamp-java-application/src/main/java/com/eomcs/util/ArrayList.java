package com.eomcs.util;

public class ArrayList {
  static final int DEFAULT_CAPACITY = 100;
  
  private Object[] list;
  private int size = 0;
  
  public ArrayList() {
    this(DEFAULT_CAPACITY); // 생성자에서 다른 생성자를 호출할수있다.
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity > 10000) {
      list = new Object[DEFAULT_CAPACITY]; // 기본사이즈 갖게 하기 안전장치 마련.
    } else {
      list = new Object[initialCapacity];
    }
  }
  
  public void add(Object obj) {
    if (this.size == list.length) {
      throw new RuntimeException("배열이 꽉 찼습니다.");
    }
    this.list[this.size++] = obj;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
}

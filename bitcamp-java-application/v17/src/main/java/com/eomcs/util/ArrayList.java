package com.eomcs.util;

import java.util.Arrays;

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
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); // 나누기 2
      list = Arrays.copyOf(this.list, newCapacity); // 길이가 더 ㅇ길면 자동으로 새 배열을 만들고 기존배열을 다 복사해옴
    }
    this.list[this.size++] = obj;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
}

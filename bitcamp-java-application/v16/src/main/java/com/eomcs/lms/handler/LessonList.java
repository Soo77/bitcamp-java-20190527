package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int DEFAULT_CAPACITY = 100;
  private Lesson[] list = new Lesson[100];
  private int size = 0;
  
  public LessonList() {
    this(DEFAULT_CAPACITY); // 생성자에서 다른 생성자를 호출할수있다.
  }
  
  public LessonList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity > 10000) {
      list = new Lesson[DEFAULT_CAPACITY]; // 기본사이즈 갖게 하기 안전장치 마련.
    } else {
      list = new Lesson[initialCapacity];
    }
  }
  
  public void add(Lesson lesson) {
    this.list[this.size++] = lesson;
  }
  
  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
}

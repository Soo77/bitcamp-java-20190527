package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> { // 클래스 이름을 변수에 받아 쓰는것
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
  
  public void add(E obj) { 
    if (this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); // 나누기 2
      list = Arrays.copyOf(this.list, newCapacity); // 길이가 더 ㅇ길면 자동으로 새 배열을 만들고 기존배열을 다 복사해옴
    }
    this.list[this.size++] = obj;
  }
 
  public Object[] toArray() { // 기존의 배열로 새 오브젝트배열을 만들어서 리턴 //파라미터 없이 호출할땐 object e로하면안됨
    return Arrays.copyOf(this.list, this.size); // 어떤 타입인지 지정하지 않으면 new Object[this.size];
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) { //타입은 여기서 가져옴.(getClass())
    //E obj = new E(); new하고 E를 쓸수없다. E에 보드가 저장되어있으면  E obj 은 가능 하지만 new는 안됨.
    // 인스턴스 만들때는 new E()라고 할수 없으므로 다른 방법을 써야함.
    if (a.length < size) {
      // 파라미터로 넘겨 받은 배열의 크기가 저장된 데이터의 개수보다 작다면 
      // 이 메서드에서 새 배열을 만든다.
      return (E[]) Arrays.copyOf(list, size, a.getClass()); // 세번째 파라미터로 지정한 타입의 배열이 생성된다.
      // new E[this.size]; 를 만든다.
      // getClass 그 레퍼런스가 가리키는 인스턴스의 타입을 리턴.
    } 
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a; // 받은 a를 그대로 리턴.
  }
  
  public int size() {
    return this.size;
  }
}

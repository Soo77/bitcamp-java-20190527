package com.eomcs.util;

import java.util.Arrays;
//import java.util.ArrayList;

// ArrayList 클래스를 List 규칙에 따라 작성한다.
// => 클래스를 선언할 때 어떤 규칙을 따를 것인지 지정해야 한다.
//    class 클래스명 implements 규칙1, 규칙2, 규칙3..
public class ArrayList<E> implements List<E> { // 클래스 이름을 변수에 받아 쓰는것
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
  
  // 인터페이스(규칙)에 정의된 메서드를 구현할 때는 오버라이딩 하는 방법과 같다.
  // => public을 더 제한할 수 없다. 인터페이스에 정의된 기능은 public이기 때문에.
  // => @Override 에노테이션을 붙일 수 있다.
  @Override
  public boolean add(E obj) { 
    if (this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1); // 나누기 2
      list = Arrays.copyOf(this.list, newCapacity); // 길이가 더 ㅇ길면 자동으로 새 배열을 만들고 기존배열을 다 복사해옴
    }
    this.list[this.size++] = obj;
    return true;
  }
 
  @Override
  public Object[] toArray() { // 기존의 배열로 새 오브젝트배열을 만들어서 리턴 //파라미터 없이 호출할땐 object e로하면안됨
    return Arrays.copyOf(this.list, this.size); // 어떤 타입인지 지정하지 않으면 new Object[this.size];
  }
  
  @Override
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
  
  @Override
  public int size() {
    return this.size;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    }
    return (E) list[index];
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    }
    
    E old = (E) list[index];
    list[index] = obj;
    
    return old;
  }
  
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    }
    
    @SuppressWarnings("unchecked")
    E old = (E) list[index];
    
    // 방법 1: 직접 반복문을 이용하여 삭제 처리하기
//    for(int i=index + 1; i<list.length; i++) {
//      list[i-1] = list[i];
//    }
//    list[--size] = null;
    
    // 방법2: 배열 복사 기능을 이용하여 삭제 처리하기
    System.arraycopy(list, index + 1, list, index, size - (index + 1));
    
    // 삭제한 후 맨 끝 값이 들어 있던 방을  null로 설정 한다.
    // => 레퍼런스가 남아있지 않게 하여 가비지가 정상적으로 이뤄지도록 한다.
    list[--size] = null;
    
    return old;
  }
  
  @Override
    public void clear() {
      for(int i = 0; i < size; i++) {
        list[i] = null;
      }
      size = 0;
    }
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("000");
    list.add("111");
    list.add("222");
    list.add("333");
    list.add("444");
    list.add("555");
    
    String old = list.remove(5);
    System.out.println("원래값: " + old);
    
    for(int i=0; i<list.size; i++) {
      System.out.println(list.get(i));
    }
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

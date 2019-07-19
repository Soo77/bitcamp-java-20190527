package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {

  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    // 현재 스택 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행한다.
    // => 새 스택을 만들고,
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 스택에서 값을 꺼내 새 스택의 새 노드에 넣는다.
      //    즉 새 스택은 값을 넣을 때 마다 새 노드를 생성하기 떄문에
      //    현재 스택의 노드에는 영향을 끼치지 않는다.
      //
      temp.push(get(i));
    }
    return temp;
    //return (Stack<E>) super.clone(); // 단순복제하면 다 끊ㄷ어버려서 다 널이 되어 버림
  }
  
  
  
  public void push(E value) {
    add(value);
  }
  
  public E pop() {
    if (size() == 0) {
      throw new ArrayIndexOutOfBoundsException("꺼낼 데이터가 없습니다.");
    }
    return remove(size() - 1);
  }
  
  public boolean empty() {
    return size() == 0;
    
  }
}
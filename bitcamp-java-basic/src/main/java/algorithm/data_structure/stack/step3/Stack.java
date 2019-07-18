package algorithm.data_structure.stack.step3;

public class Stack<E> extends LinkedList<E> {

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

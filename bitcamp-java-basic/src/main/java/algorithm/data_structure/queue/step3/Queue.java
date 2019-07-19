package algorithm.data_structure.queue.step3;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    // 현재 큐 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행한다.
    // => 새 큐를 만들고,
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 큐에서 값을 꺼내 새큐의 새 노드에 넣는다.
      //    즉 새 큐는 값을 넣을 때 마다 새 노드를 생성하기 떄문에
      //    현재 큐의 노드에는 영향을 끼치지 않는다.
      //
      temp.offer(get(i));
    }
    return temp;
    //return (Stack<E>) super.clone(); // 단순복제하면 다 끊ㄷ어버려서 다 널이 되어 버림
  }
  
  
  
  public void offer(E value) {
    add(value);
  }
  
  public E poll() {
    return remove(0);
  }
  
  
  public boolean empty() {
    return size() == 0;
  }
}

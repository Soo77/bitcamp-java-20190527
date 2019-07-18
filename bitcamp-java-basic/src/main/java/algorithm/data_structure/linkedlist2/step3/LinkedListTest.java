package algorithm.data_structure.linkedlist2.step3;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
//    list.add("aaa"); //aaa의 주소가 넘어간다
//    list.add("bbb");
//    list.add("ccc");
//    list.add("ddd");
//    list.add("eee");
//    list.add("fff");
//    list.add("ggg");
    
//    list.remove(3); // "ddd" 삭제
//    list.remove(0); // "aaa" 삭제
//    list.remove(4); // "ggg" 삭제
//    list.remove(0); // "bbb" 삭제
//    list.remove(0); // "ccc" 삭제
//    list.remove(0); // "eee" 삭제
//    list.remove(0); // "fff" 삭제
    
    list.add("okok");
    list.add("nono");
    list.add("hul");
    
    //list.clear();
    
//    for (int i = 0; i < list.size(); i++) {
//      Object value = list.get(i);
//      System.out.println(value);
//    }
    
    String[] array = list.toArray(new String[] {});
    for (Object obj : array) {
      System.out.println(obj);
    }

    
  }
}

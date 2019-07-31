package design_pattern.observer.before.v1;

public class Car {
  public void start() {
    System.out.println("시동을 건다.");
  }
  
  public void run() {
    System.out.println("달린다.");
  }
  
  public void stop() {
    System.out.println("시동을 끈다.");
    /*
    
    // 예) 4월 15일 - 자동차 시동을 끌 때 전조등 자동 끄기 기능을 추가
    System.out.println("전조등을 끈다.");
    
    // 예) 5월 5일 - 자동차 시동을 끌 때 썬루프 자동 닫기 기능을 추가
    System.out.println("썬루프를 닫는다.");
    */
  }
}







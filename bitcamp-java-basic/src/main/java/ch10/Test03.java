// 인스턴스 필드의 초기화 - 인스턴스를 만들어 쓰는 개발자가 직접 초기화를 수행하기 
package ch10;

class Monitor1 {
  
  // 인스턴스 변수(클래스 변수 포함)가 생성되면 0으로 자동 초기화 된다.
  // byte, short, int, long = 0
  // float, double = 0.0
  // boolean = false
  // char = '\u0000'
  //
  // 주의! 로컬 변수는 자동 초기화 되지 않는다.
  // 
  int bright; // 밝기 (0% ~ 100%)
  int contrast; // 명암 (0% ~ 100%)
  int widthRes; // 해상도 너비
  int heightRes; // 해상도 높이
  
  void display() {
    System.out.println("----------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("----------------------------------");
  }
}

public class Test03 {
  public static void main(String[] args) {
    // 모니터 인스턴스 생성
    Monitor1 m1 = new Monitor1();
    
    // 모니터의 중요 필드 값을 초기화시키지 않고 사용하면 제대로 동작이 안 될 수 있다.
    m1.display(); // 현실 세계에서 모니터의 각 값들이 유효한 기본 값으로 초기화 되지 않은 상태에서 
                  // 모니터를 켠다면? 까만 화면만 볼 뿐이다. 
                  // 사용자는 모니터가 고장난 줄 알고 AS를 요청할 것이다.
    
    // 그래서 모니터를 만든 후 출하하기 전에 
    // 모니터의 인스턴스 필드의 값을 유효한 값으로 설정해야 한다.
    // 그래야 모니터의 기능(funciton=method)을 제대로 사용할 수 있다.
    // 
    // 다음은 모니터 인스턴스를 만든 후 에 모니터 인스턴스를 사용하는 사용자가 
    // 직접 값을 초기화시킨 후 사용하는 예이다.
    m1.bright = 50;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.bright = 1080;
    
    m1.display();
    
    // 고객의 의견! 
    // => 모니터를 구매한 후 바로 사용할 수 있도록 모니터의 속성 값들이 유효한 값으로 
    //    미리 초기화 되었으면 좋겠습니다!
    //
    // 이 클래스를 사용하는 다른 개발자의 의견!
    // => 인스턴스의 메서드를 사용하는데 문제가 없도록 인스턴스의 각 필드를 유효한 값으로 
    //    미리 초기화 했으면 좋겠습니다!
    
  }
}

















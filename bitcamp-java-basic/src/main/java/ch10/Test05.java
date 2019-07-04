// 인스턴스 필드의 초기화 - 인스턴스 블록을 통해 필드를 초기화 하기 
package ch10;

class Monitor3 {
  int bright; // 밝기 (0% ~ 100%)
  int contrast; // 명암 (0% ~ 100%)
  int widthRes; // 해상도 너비
  int heightRes; // 해상도 높이
  
  { // 인스턴스 블록 <= 실무에서는 인스턴스 블록을 잘 사용하지 않는다. 대신에 생성자를 주로 사용한다.
    this.bright = 50;
    this.contrast = 50;
    this.widthRes = 1920;
    this.heightRes = 1080;
  }
  
  void display() {
    System.out.println("----------------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
    System.out.println("----------------------------------");
  }
}

public class Test05 {
  public static void main(String[] args) {
    // 모니터 인스턴스 생성
    Monitor3 m1 = new Monitor3();
    
    // 인스턴스 필드의 값이 인스턴스 블록을 통해 유효한 기본 값들로 
    // 미리 초기화 되었기 때문에 바로 사용할 수 있다.
    m1.display(); 
    
    // 물론 특정 속성의 값을 바꾼 후에 사용해도 된다.
    m1.bright = 40;
    
    m1.display();
  }
}

















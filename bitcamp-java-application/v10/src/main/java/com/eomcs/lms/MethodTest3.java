package com.eomcs.lms;

public class MethodTest3 {
  public static void main(String[] args) {
    String str = "Hello";
    
    
    // 인스턴스(클래스 설계도에 따라 만든 메모리; 데이터가 들어 있는 메모리) 메서드?
    // => 데이터를 가지고 실행하는 메서드
    // => 데이터가 있어야만 실행하는 메서드
    // => 레퍼런스는 데이터가 들어 있는 인스턴스를 가리킨다.
    // => 그래서 레퍼런스를 가지고 메서드(기능)를 실행하는 것이다.
    char ch = str.charAt(2);
    System.out.println(ch);
    
    // 클래스 메서드(스태틱 메서드)?
    // => 데이터 없이 실행하는 메서드
    // => 필요하다면 아규먼트로 값을 받아 실행하는 메서드
    // => 인스턴스를 사용하지 않는 메서드
    // => 그래서 인스턴스를 가리키는 레퍼런스 없이 클래스 이름으로 메서드를 실행하는 것이다.
    String str2 = String.valueOf(100);
    String str3 = str.valueOf(100);
    System.out.println(str2);
  }
  

  // 인스턴스 메서드 정의
  // => 메서드를 정의할 때 static을 붙이지 안으면 인스턴스 메서드이다.
  // => 인스턴스 메서드를 호출할 때는 
  void m1() {
    
  }
  
  // 클래스 메서드(스태틱 메서드)
  // => 메서드를 정의할 때 리턴 타입 앞에 static을 붙인다.
  // => 클래스 메서드를 호출할 때는 클래스 이름만 있으면 된다.
  //    물론 인스턴스 주소로 호출할 수도 있다.
  static void m2() {
    
  }
}

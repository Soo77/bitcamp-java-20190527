package ch28.e;

// 필수 프로퍼티
public @interface MyAnnotation {
  // 모양은 메서드 형태이고,
  // 값을 꺼낼 때도 메서드 호출로 꺼낸다.
  // 그러나 에노케이션에서 값을 설정할 때는
  // 다음과 같이 변수 형태를 사용한다.
  // value = "hello"
  // 따라서 이름은 변수형태로 짓는다.
  // 즉 getvalue가 아니라 value라고 한다.
  
  String value();
}

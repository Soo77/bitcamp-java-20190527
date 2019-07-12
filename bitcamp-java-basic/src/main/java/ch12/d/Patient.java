package ch12.d;

public class Patient {
  public static final int WOMAN = 1; // 클래스가 로딩될 때 딱 한번만 만들어짐.
  public static final int MAN = 2;
  // 퍼뷸릭까지 붙이면 이것이 상수.
  
  String name;
  int age;
  int height;
  int weight;
  int gender;
  
  public String toString() {
    return String.format("name=%s, age=%d, height=%d, weight=%d, gender=%d",
        this.name, this.age, this.height, this.weight, this.gender);
  }
}


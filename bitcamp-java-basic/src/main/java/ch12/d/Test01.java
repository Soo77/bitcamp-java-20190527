// 캡슐화(encapsulation) : 적용 전
package ch12.d;

public class Test01 {

  public static void main(String[] args) {
    
    Patient p = new Patient();
    p.name = "김영희";
    p.age = 20;
    p.weight = 60;
    p.height = 157;
    p.gender = Patient.WOMAN;
    
    System.out.println(p);
  }

}

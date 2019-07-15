// Wrapper 클래스
package ch11;

import java.util.Date;

public class Test09_1_01 {
  public static void main(String[] args) {
    
    Integer i1 = Integer.valueOf(500);
    
    Character c1 = Character.valueOf('가');
    
    byte b = i1.byteValue();
    System.out.println(b);
    String s = i1.toString();
    System.out.println(s);
    String str = Integer.toHexString(200);
    System.out.println(str);
  }
}

















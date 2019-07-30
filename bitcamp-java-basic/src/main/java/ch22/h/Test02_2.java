// 파일 입출력 객체에 데코레이터 연결하기 :try-with-resources
package ch22.h;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_2 {
  public static void main(String[] args) throws Exception {

    // 파일에서 데이터를 읽는 일을 할 객체를 준비한다.
    
    try (DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("temp3/data.bin")))) {
            
        out.write(0x11223344);
        
    } catch (IOException e) {
      
      System.out.println("파일 입출력 예외발생");
      e.printStackTrace();

    } finally {
      // try-with-resources 문법은 try 블록을 벗어날 때 자동으로 close()가 호출된다.
      // 따라서 
    }
    System.out.println("출력 완료!");
  }
}









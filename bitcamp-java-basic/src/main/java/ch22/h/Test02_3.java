// 파일 입출력 객체에 데코레이터 연결하기 
package ch22.h;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_3 {
  public static void main(String[] args) throws Exception {

    // 파일에서 데이터를 읽는 일을 할 객체를 준비한다.
    DataOutputStream out = null;
    
    try {
        out = new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("temp3/data.bin")));
            
        out.write(0x11223344);
        
    } catch (IOException e) {
      System.out.println("파일 입출력 예외발생");
      e.printStackTrace();
    } finally {
      // 실제 가장 바깥 입출력 객체를 close() 하면
      // 입출력 객체를 찾아가면서 
      try {out.close();} catch (Exception e2) {}
    }
    System.out.println("출력 완료!");
  }
}









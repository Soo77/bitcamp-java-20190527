// 파일 입출력 객체에 데코레이터 연결하기 
package ch22.h;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_2 {
  public static void main(String[] args) throws Exception {

    // 파일에서 데이터를 읽는 일을 할 객체를 준비한다.
    FileOutputStream out1 = null;
    BufferedOutputStream out2 = null; 
    DataOutputStream out3 = null;
    
    try {
        out1 = new FileOutputStream("temp3/data.bin");
        out2 = new BufferedOutputStream(out1);
        out3 = new DataOutputStream(out2);
        
        out3.write(0x11223344);
        
    }catch (IOException e) {
      System.out.println("파일 입출력 예외발생");
      e.printStackTrace();
    } finally {
      // 입출력 객체를 닫을 때는 가장 바깥의 객체부터 닫아라!
      try {out3.close();} catch (Exception e2) {}
      try {out2.close();} catch (Exception e2) {}
      try {out1.close();} catch (Exception e2) {}
    }
    System.out.println("출력 완료!");
  }
}









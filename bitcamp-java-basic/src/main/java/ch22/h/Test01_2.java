// 버퍼없이 대량의 primitive 타입의 값을 읽기
package ch22.h;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test01_2 {
  public static void main(String[] args) throws Exception {

    // 파일에서 데이터를 읽는 일을 할 객체를 준비한다.
    FileOutputStream out = null;
        
    try {
        out = new FileOutputStream("temp3/data.bin");
        out.write(0x55);
    }catch (IOException e) {
      System.out.println("파일 입출력 예외발생");
      e.printStackTrace();
    } finally {
      try {out.close();} catch (Exception e2) {}
    }
    System.out.println("출력 완료!");
  }
}









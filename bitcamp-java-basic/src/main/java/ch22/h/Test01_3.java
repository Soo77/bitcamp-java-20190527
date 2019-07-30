// 버퍼없이 대량의 primitive 타입의 값을 읽기
package ch22.h;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test01_3 {
  public static void main(String[] args) throws Exception {

    // 파일에서 데이터를 읽는 일을 할 객체를 준비한다.
      
    // try-with-resource 문법
    // java.lang.AutoCloseable 구현체인 경우
    // try 블록을 벗어나기 전에 자동으로 close()가 호출되게 하는 문법
    // => 이 문법을 사용하면 개발자가 finally 블록에서 일일이 close()를 호출하는 번거로움 피핡수잇음
    // 문법:
    // try (AutoCloseable 객체준비) {
    // } catch (...) {
    // } finally {
    // }
    //
    try (FileOutputStream out = new FileOutputStream("temp3/data.bin")) {
      
      out.write(0x55);
      
    }catch (IOException e) {
      System.out.println("파일 입출력 예외발생");
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
}









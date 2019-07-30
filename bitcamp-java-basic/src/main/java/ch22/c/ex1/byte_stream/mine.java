package ch22.c.ex1.byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class mine extends FileInputStream {

  public mine(String name) throws FileNotFoundException {
    super(name);
  }
  
  byte[] buf = new byte[8192];
  int size = 0;
  int cursor = 0;
  int count = 0;
  
  public static void main(String[] args) throws Exception {
    BufferedInputStream in = new BufferedInputStream("temp/jls12.pdf");

    System.out.println("데이터 읽는 중...");

    long start = System.currentTimeMillis();

    System.out.println("시작");
    int b;
    int count = 0;
    //in.read();

    while ((b = in.read()) != -1) {
      count++;
    }

    long end = System.currentTimeMillis();
    
    System.out.println("이만큼걸ㄹ림" + (end - start));
    System.out.println(in.count);

    in.close();

    System.out.println("출력 완료!");
    
  }
  
//  public int read() throws IOException {
//    if (cursor >= size) { // 버퍼에 보관된 데이터를 다 읽었으면, 
//      System.out.println(size);
//      count++;
//      size = read(buf); // 다시 상속 받은 메서드를 사용하여 8192 바이트를 읽어 온다.
//      if (size == -1) // 물론 읽은 데이터가 없다면, 즉 파일의 데이터를 다 읽었다면 -1을 리턴한다.
//        return -1;
//      cursor = 0; // 새로 8192 바이트를 읽어 버퍼에 저장했다면,
//    }             // 다시 커서의 위치를 0으로 설정한다.
//    return buf[cursor++] & 0x000000ff; 
//  }

}

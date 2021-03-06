// java.io.File 클래스 : 필터 사용하기 II
package ch22.a;

import java.io.File;
import java.io.FilenameFilter;

public class Test10_2 {

  public static void main(String[] args) throws Exception {
    
    // local class
    class TextFileFilter implements FilenameFilter {
      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
      }
    }
    
    File file = new File(".");
    
    String[] names = file.list(new TextFileFilter());
    
    for (String name : names) {
      System.out.println(name);
    }
    
  }    
}










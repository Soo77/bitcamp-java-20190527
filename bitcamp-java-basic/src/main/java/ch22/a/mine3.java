package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class mine3 {

  public static void main(String[] args) {
    
    File dir = new File("bin/main");
    
    findClass(dir, "");

    System.out.println("완료!");
  }

  static void findClass(File path, String packageName) {

    if (path.isFile()) {
      System.out.println(String.format("%s.%s",
          packageName,
          path.getName().replace(".class", "")).substring(1));
      return;
    }
    
    File[] files = path.listFiles(
        f -> f.isDirectory() || f.getName().endsWith(".class"));
    
    for (File file : files) {
      if (file.isDirectory()) {
        findClass(file, packageName + "." + file.getName());
      } else {
        findClass(file, packageName);
        
      }
    }
    
    
    
  }

  
}

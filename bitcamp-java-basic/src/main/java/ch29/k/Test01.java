package ch29.k;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test01 {
  public static void main(String[] args) throws Exception {
    
    String url = "/aaa/okok/a.gif";
    System.out.println(URLDecoder.decode(url, "UTF-8"));
  }
}

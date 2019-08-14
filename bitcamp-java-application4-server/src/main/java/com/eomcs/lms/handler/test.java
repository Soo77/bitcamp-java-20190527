package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

  public static void main(String[] args) throws IOException {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String str = in.readLine();
    System.out.println(str);
  }
}

package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import com.eomcs.util.Component;
import com.eomcs.util.RequestMapping;

@Component("/hello")
public class HelloCommand {
  
  @RequestMapping
  public void execute(BufferedReader in, PrintStream out) {
    out.println("안녕하세요!");
  }

}

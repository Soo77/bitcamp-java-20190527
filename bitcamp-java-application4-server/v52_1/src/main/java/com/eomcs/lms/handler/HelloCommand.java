package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class HelloCommand {
  
  @RequestMapping("/hello")
  public void execute(BufferedReader in, PrintStream out) {
    out.println("안녕하세요!");
  }

}

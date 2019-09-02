package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import org.springframework.stereotype.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

@Component
public class CalculatorCommand {


  @RequestMapping("/calc/plus")
  public void plus(BufferedReader in, PrintStream out) {
    try {
      int n1 = Input.getIntValue(in, out, "값1? ");
      int n2 = Input.getIntValue(in, out, "값2? ");
      out.printf("%d + %d = %d\n", n1, n2, (n1+n2));
    } catch (Exception e) {
      out.println("계산기 실행에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/calc/minus")
  public void minus(BufferedReader in, PrintStream out) {
    try {
      int n1 = Input.getIntValue(in, out, "값1? ");
      int n2 = Input.getIntValue(in, out, "값2? ");
      out.printf("%d - %d = %d\n", n1, n2, (n1-n2));
    } catch (Exception e) {
      out.println("계산기 실행에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
}

// 실습 과제:
// => 다음과 같이 실행하도록 위 클래스를 완성하라.
// 
/*
> /calc/plus
값1? 100
값2? 200
100 + 200 = 300

> /calc/minus
값1? 100
값2? 200
100 - 200 = -100
*/
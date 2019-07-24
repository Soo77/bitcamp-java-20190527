package com.eomcs.lms.handler;

import com.eomcs.util.Input;

public class CalcPlusCommand implements Command {

  Input input;
  
  public CalcPlusCommand(Input input) {
    this.input = input;
  }
  
  @Override
  public void execute() {
    int val1 = input.getIntValue("값1?");
    int val2 = input.getIntValue("값2?");
    int sum = val1 + val2;
    System.out.println("합계는 " + sum + "입니다.");
  }

}

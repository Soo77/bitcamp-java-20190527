package ch06;

public class Testx14 {
  
  public static void main(String[] args) {

    System.out.printf("이름: %s\n", args[0]);
    
    int sum = 0;
    for(int i=1; i<args.length; i++) {
      sum += Integer.parseInt(args[i]);
    }
    System.out.printf("합계: %s\n", sum);
    System.out.printf("평균: %s\n", (float)sum / (args.length-1));
    
  }
}

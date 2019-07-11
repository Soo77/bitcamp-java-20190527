package ch09.test;

public class Test {
  
  public static void main(String[] args) {
    // 계산하기
    // => 2 * 3 - 2 + 7 = ?
    // => 6 / 2 + 4 = ?
    
    // 계산식1의 결과를 저장할 메모리
    Calculator calc1= new Calculator();
    
    // 계산식2의 결과를 저장할 메모리
    Calculator calc2 = new Calculator();
    
    
    int i = 10;
    i++;
    
    
    // Calculator 클래스에는 result 변수가 한 개만 있기 때문에
    // 두 개의 계산식을 동시에 수행할 수 있다.
    // 다음과 같이 한 개의 식을 모두 계산한 다음에
    // 두번째 식을 계산해야한다.
    // 이것이 클래스 필드의 한계이다.
    // 해결책? 개별적으로 관리되어야 하는 값은 인스턴스 변수에 저장한다.
    
    calc1.plus(2);
    calc2.plus(6);
    
    calc1.multiple(3);
    calc2.divide(2);
    
    calc1.minus(2);
    calc2.plus(4);
    
    calc1.plus(7);
    

    System.out.printf("계산식1의 결과 = %d\n", calc1.result);
    System.out.printf("계산식2의 결과 = %d\n", calc2.result);
  }
}

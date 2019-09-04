// 팩토리 클래스가 생성한 객체를 IoC 컨테이너에 보관하기 II
package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ch29.SpringUtils;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/f/application-context-02.xml");
    
    SpringUtils.printObjects(iocContainer);
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
  }
}







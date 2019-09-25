package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInitializerImpl implements MyWebInitializer {

  @Override
  public void start(ServletContext ctx) {
    System.out.println("MyWebInitializerImpl... ok!");
    
    // DispatcherServlet 에서 사용할 스프링 IoC 컨테이너를 준비한다.
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.refresh();
    
    // DispatcherServlet 인스턴스를 생성한다.
    DispatcherServlet servlet = new DispatcherServlet(ac);
    Dynamic registration = ctx.addServlet("app", servlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/app/*");
  }
}

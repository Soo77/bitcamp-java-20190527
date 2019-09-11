package com.eomcs.lms;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

//이 클래스는 스프링 IoC 컨테이너를 설정하는 클래스임을 표시한다.
@Configuration
@PropertySource("classpath:com/eomcs/lms/conf/jdbc.properties")
public class DatabaseConfig {
  
  @Value("${jdbc.driver}") String jdbcDriver;

  @Value("${jdbc.url}") String jdbcUrl;
  
  @Value("${jdbc.username}") String jdbcUsername;
  
  @Value("${jdbc.password}") String jdbcPassword;
  
  @Bean
  public DataSource dataSource() {
    System.out.println("dataSource()");
    // spring-jdbc 라이브러리에서 제공해주는 클래스를 사용하여 DataSource 구현체 만들기
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(this.jdbcDriver); 
    ds.setUrl(this.jdbcUrl);
    ds.setUsername(this.jdbcUsername);
    ds.setPassword(this.jdbcPassword);
    return ds;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    System.out.println("transactionManager()");
    return new DataSourceTransactionManager(dataSource);
  }
}







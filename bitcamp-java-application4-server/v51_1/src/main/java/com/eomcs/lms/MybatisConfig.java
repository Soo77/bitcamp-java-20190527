package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 클래스는 스프링 IoC 컨테이너를 설정하는 클래스임을 표시한다.
@Configuration
@MapperScan("com.eomcs.lms.dao")

public class MybatisConfig {
  
  // Mybatis의 SqlSessionFactory 객체 준비
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext appCtx) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    sqlSessionFactoryBean.setMapperLocations(
        appCtx.getResources("classpath:com/eomcs/lms/mapper/*Mapper.xml"));
    
    return sqlSessionFactoryBean.getObject();
  }
}







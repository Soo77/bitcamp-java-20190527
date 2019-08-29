package com.eomcs.util;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MybatisDaoFactory {
  SqlSessionFactory sqlSessionFactory;

  public MybatisDaoFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @SuppressWarnings("unchecked")
  public <T> T createDao(Class<T> clazz) {
    return (T) Proxy.newProxyInstance(
        
        clazz.getClassLoader(),
        
        new Class[] {clazz},
        
        (Object proxy, Method method, Object[] args) -> {
          String interfaceName = clazz.getName();
          String methodName = method.getName();
          String sqlId = interfaceName + "." + methodName;
          
          Class<?> retType = method.getReturnType();
          
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            if (retType == List.class) {
              // 리턴 타입이 List일 경우 select 문을 실행하는 것이다.
              return  (args == null) ? sqlSession.selectList(sqlId) :
                sqlSession.selectList(sqlId, args[0]);
            } else if (retType == int.class || retType == void.class) {
              return  (args == null) ? sqlSession.insert(sqlId) :
                sqlSession.insert(sqlId, args[0]);
            } else {
              return  (args == null) ? sqlSession.selectOne(sqlId) :
                sqlSession.selectOne(sqlId, args[0]);
            }
          }
        });
  }
}

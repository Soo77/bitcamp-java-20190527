package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO가 사용할 커넥션 객체를 생성해주는 역할
public class DataSource {

  String jdbcDriver;
  String jdbcUrl;
  String username;
  String password;

  // 스레드 별로 커넥션 객체를 사용하기 위해 
  // 현재 스레드의  값을 넣고 꺼낼 수 있는 도구를 준비한다.
  ThreadLocal<Connection> localConnection = new ThreadLocal<>();

  ArrayList<Connection> conPool = new ArrayList<>();

  public DataSource(String jdbcDriver, String jdbcUrl, String username, String password) {
    this.jdbcDriver = jdbcDriver;
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }



  public Connection getConnection() throws Exception {
    // ThreadLocal 도구를 사용하여 현재 스레드에서 커넥션 객체를 꺼낸다.
    Connection con = localConnection.get();

    if (con == null) {// 없다면,
      // 커넥션 풀에서 꺼낸다.
      if (conPool.size() > 0) { // 먼저 커넥션풀에서 커넥션을 찾아보고 있으면 꺼낸다.
        con = conPool.remove(0);
        System.out.println("기존 커넥션 사용!"); 
      } else {
        
        Class.forName(jdbcDriver);
        con = new TxConnection(DriverManager.getConnection(jdbcUrl, username, password));
        System.out.println("새 커넥션 만들어 사용");
      }
      // 생성한 커넥션을 리턴하기 전에 TheardLocal 도구를 사용하여 현재 스레드에 보관한다.
      localConnection.set(con);
    }

    return con;
  }

  // 현재 스레드에 보관된 커넥션 객체를 삭제한다.
  public void clearConnection() {
    Connection con = localConnection.get();
    if (con != null) {
      try {((TxConnection)con).realClose();} catch (SQLException e) {}
      localConnection.remove();
      // 스레드에서 제거한 후, 커넥션 객체를 다시 커넥션풀에 저장한다.
      conPool.add(con);
      System.out.println("커넥션풀에 다시 저장!");
    }
  }

}

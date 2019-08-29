package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class LoginCommand implements Command {
  
  private SqlSessionFactory sqlSessionFactory;
  
  public LoginCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(BufferedReader in, PrintStream out) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
      HashMap<String,Object> params = new HashMap<>();
      params.put("email", Input.getStringValue(in, out, "이메일? "));
      params.put("password", Input.getStringValue(in, out, "암호? "));
      
      
      Member member = memberDao.findByEmailPassword(params);
      if (member == null) {
        out.println("이메일 혹은 암호가 맞지 않습니다!");
      } else {
        out.printf("%s 님 환영합니다.\n", member.getName());
      }
      
    } catch (Exception e) {
      out.println("로그인 실행에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }

}

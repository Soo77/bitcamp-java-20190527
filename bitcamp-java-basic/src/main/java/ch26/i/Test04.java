// 트렌잭션 다루기 - Mybatis + SqlSessionFactoryProxy 로 트랜잭션 제어하기
package ch26.i;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream("ch26/i/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    // 여러 메소드에서 같은 sqlSession을 사용하는 방법
    // => 멀티 스레드 환경이라 가정하자!
    // => 같은 스레드의 경우 같은 SqlSession을 사용하면 트랜젝션을 처리할 수 있다.
    // 해결책?
    // => SqlSessionFacotry의 프록시를 만들어SqlSession을 리턴할 때
    // 같은 스레드에 대해 가은 SqlSession을 리턴하도록 한다.

    SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

    // 서로다른 SqlSession으로 데이터 변경 작업(insert/update/delete)을 하면
    // 같은 트랜젝션으로 다룰 수 없다.

    try {
      insert1(sqlSessionFactoryProxy);
      insert2(sqlSessionFactoryProxy);
      sqlSessionFactoryProxy.openSession().commit();
    } catch (Exception e) {
      sqlSessionFactoryProxy.openSession().rollback();
    }
    printList(sqlSessionFactoryProxy);
    
    // SqlSession 객체의 사용이 끝났으면 close한다.
    // 단 실제 SqlSessionProxy로 형변환 한 후 realClose()를 호출한다.
    ((SqlSessionProxy)sqlSessionFactoryProxy.openSession()).realClose();
  }

  static void insert1(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.insert("board.insert", new Board().setTitle("a107").setContents("내용7"));
    // SqlSessionProxy
    sqlSession.close();
  }

  static void insert2(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Board board = new Board();
//    board.setTitle("a108");
    board.setContents("내용8");
    sqlSession.insert("board.insert", board);
    sqlSession.close();
  }

  static void printList(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<Board> boards = sqlSession.selectList("board.select");
    for (Board b : boards) {
      System.out.println(b);
    }
    sqlSession.commit();
    sqlSession.close();
  }
}


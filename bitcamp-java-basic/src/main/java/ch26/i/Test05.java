// 트렌잭션 다루기 - Mybatis + Connection 으로 트랜잭션 제어하기
package ch26.i;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
  
  static DataSource dataSource;

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream("ch26/i/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    dataSource = new DataSource( 
    
    "org.mariadb.jdbc.Driver",
    "jdbc:mariadb://localhost/bitcampdb",
    "bitcamp",
    "1111");

    // 서로다른 SqlSession으로 데이터 변경 작업(insert/update/delete)을 하면
    // 같은 트랜젝션으로 다룰 수 없다.

    try {
      dataSource.getConnection().setAutoCommit(false);
      insert1(sqlSessionFactory);
      insert2(sqlSessionFactory);
      //((TxConnection)dataSource.getConnection()).realCommit();
    } catch (Exception e) {
      ((TxConnection)dataSource.getConnection()).realRollback();
    }
    printList(sqlSessionFactory);
    
    // SqlSession 객체의 사용이 끝났으면 close한다.
    // 단 실제 SqlSessionProxy로 형변환 한 후 realClose()를 호출한다.
  }

  static void insert1(SqlSessionFactory sqlSessionFactory) throws Exception {
    // SqlSession이 사용할 커넥션 객체를 준비한다.
    // => DataSource는 같은 스레드에 대해 같은 커넥션을 리턴한다.
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    sqlSession.insert("board.insert", new Board().setTitle("a23").setContents("내용23"));
    // SqlSessionProxy
    sqlSession.close();
  }

  static void insert2(SqlSessionFactory sqlSessionFactory) throws Exception {
    // SqlSession이 사용할 커넥션 객체를 준비한다.
    // => DataSource는 같은 스레드에 대해 같은 커넥션을 리턴한다.
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    Board board = new Board();
    board.setTitle("a24");
    board.setContents("내용24");
    sqlSession.insert("board.insert", board);
    sqlSession.close();
  }

  static void printList(SqlSessionFactory sqlSessionFactory) throws Exception {
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    List<Board> boards = sqlSession.selectList("board.select");
    for (Board b : boards) {
      System.out.println(b);
    }
    sqlSession.commit();
    sqlSession.close();
  }
}


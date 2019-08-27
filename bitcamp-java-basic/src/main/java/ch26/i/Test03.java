// 트렌잭션 다루기 - Mybatis + SqlSessionFactoryProxy 로 트랜잭션 제어하기
package ch26.i;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream("ch26/i/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 서로다른 SqlSession으로 데이터 변경 작업(insert/update/delete)을 하면
    // 같은 트랜젝션으로 다룰 수 없다.
    insert1(sqlSessionFactory);
    insert2(sqlSessionFactory);
    printList(sqlSessionFactory);
  }

  static void insert1(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.insert("board.insert", new Board().setTitle("a103").setContents("내용"));
    sqlSession.close();
  }

  static void insert2(SqlSessionFactory sqlSessionFactory) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Board board = new Board();
    board.setTitle("a104");
    board.setContents("내용");
    sqlSession.insert("board.insert", board);

    sqlSession.commit();
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


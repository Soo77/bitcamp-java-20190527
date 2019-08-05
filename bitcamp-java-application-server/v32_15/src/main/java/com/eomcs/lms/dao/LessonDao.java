package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;


// 수업관리 DAO 사용규칙을 정의한다.
public interface LessonDao {

  int insert(Lesson lesson) throws Exception;
  List<Lesson> findAll() throws Exception;
  Lesson findBy(int no) throws Exception;
  int update(Lesson lesson) throws Exception;
  int delete(int no) throws Exception;
  
}


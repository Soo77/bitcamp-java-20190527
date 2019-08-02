package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Lesson;

public class LessonServlet implements Servlet {
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  
  ObjectInputStream in;
  ObjectOutputStream out;
  
  public LessonServlet(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }
  @Override
  public void service(String command) throws Exception {
    switch (command) {
      
      case "/lesson/add":
        // 클라이언트가 보낸 객체를 읽는다.
        addLesson();
        break;
      case "/lesson/list":
        listLesson();
        break;
      case "/lesson/delete":
        deleteLesson();
        break;
      case "/lesson/detail":
        detailLesson();
        break;
      case "/lesson/update":
        updateLesson();
        break;
      default:
        out.writeUTF("fail");
        out.writeUTF("지원하지 않는 명령입니다.");
    }
  }
  
  private void updateLesson() throws Exception {
    Lesson lesson = (Lesson)in.readObject();

    int index = indexOfLesson(lesson.getNo());
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    lessonList.set(index, lesson);
    out.writeUTF("ok");

  }

  private void detailLesson() throws Exception {
    int no = in.readInt();

    int index = indexOfLesson(no);
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    out.writeUTF("ok");
    out.writeObject(lessonList.get(index));

  }


  private void deleteLesson() throws Exception {
    int no = in.readInt();

    int index = indexOfLesson(no);
    if (index == -1) {
      fail("해당 번호의 강의가 없습니다.");
      return;
    }
    lessonList.remove(index);
    out.writeUTF("ok");
   }

  private void addLesson() throws Exception {
    Lesson lesson = (Lesson)in.readObject();
    out.writeUTF("ok");
    lessonList.add(lesson);
  }

  private void listLesson() throws Exception {
    out.writeUTF("ok");
    out.reset(); // 기존에 serialize 했던 객체의 상태를 무시하고 다시 serialize한다.
    out.writeObject(lessonList);
  }

  private int indexOfLesson(int no) {
    int i = 0;
    for (Lesson m : lessonList) {
      if (m.getNo() == no) {
        return i;
      }
      i++;
    }
    return -1;
  }
  
  private void fail(String cause) throws Exception {
    out.writeUTF("fail");
    out.writeUTF(cause);
  }

}

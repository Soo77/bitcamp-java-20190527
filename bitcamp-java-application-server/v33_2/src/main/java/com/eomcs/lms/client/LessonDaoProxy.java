package com.eomcs.lms.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoProxy implements LessonDao {
  String host;
  int port;

  public LessonDaoProxy(String host, int port) {
    this.host = host;
    this.port = port;
  }
  @Override
  public int insert(Lesson lesson) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/lesson/add");
      out.writeObject(lesson);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Lesson> findAll() throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/lesson/list");
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return (List<Lesson>) in.readObject();
    }
  }


  @Override
  public Lesson findBy(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/lesson/detail");
      out.writeInt(no);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return (Lesson) in.readObject();
    }
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/lesson/update");
      out.writeObject(lesson);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/delete");
      out.writeInt(no);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }


}

package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class MemberHandler {
  
  private ArrayList<Member> memberList = new ArrayList<>();
  public Input input;
  
  public MemberHandler(Input input) {
    this.input = input;
  }
  
  public void addMember() {
    Member member = new Member();
    
    member.setNo(input.getIntValue("번호 ?"));
    member.setName(input.getStringValue("이름? "));
    member.setEmail(input.getStringValue("이메일? "));
    member.setPw(input.getStringValue("암호? "));
    member.setPic(input.getStringValue("사진? "));
    member.setPhoneNum(input.getStringValue("전화? "));
    member.setSignedUpDate(new Date(System.currentTimeMillis()));
    
    memberList.add(member);
    System.out.println("저장하였습니다.");
    
  }
  
  public void listMember() {
    Member[] members = memberList.toArray(new Member[] {});
    for (Member member : members){
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", 
          member.getNo(), member.getName(), member.getEmail(), member.getPw(), 
          member.getPic(), member.getPhoneNum(), member.getSignedUpDate());
    }
  }

  public void detailMember() {
    int no = input.getIntValue("번호 ?");
    
    // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체를 찾는다.
    Member member = null;
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break; 
      }
    }
    
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; // 함수 리턴타입이 void라면 함수를 끝내고싶을때 그냥 return하면 됨.
    }
    
    // null이 아니면 데이터를 찾았다는 것이기 떄문에 찾은 데이터를 프린트해준다.
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPw());
    System.out.printf("사진: %s\n", member.getPic());
    System.out.printf("전화: %s\n", member.getPhoneNum());
    System.out.printf("가입일: %s\n", member.getSignedUpDate());
    
    
  }

  public void updateMember() {
    int no = input.getIntValue("번호 ?");
    
    // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체를 찾는다.
    Member member = null;
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break; 
      }
    }
    
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; // 함수 리턴타입이 void라면 함수를 끝내고싶을때 그냥 return하면 됨.
    }
    
    String str = input.getStringValue("이름(" + member.getName() + ")? ");
    if (str.length() > 0) {
      member.setName(str);
    }
    
    str = input.getStringValue("암호?(" + member.getPw() + ")?");
    if (str.length() > 0) {
      member.setPw(str);
    }
    
    str = input.getStringValue("사진?(" + member.getPic() + ")?");
    if (str.length() > 0) {
      member.setPic(str);
    }
    
    str = input.getStringValue("전화?(" + member.getPhoneNum() + ")?");
    if (str.length() > 0) {
      member.setPhoneNum(str);
    }
    
    System.out.println("데이터를 변경하였습니다.");
    
  }

  public void deleteMember() {
    int no = input.getIntValue("번호 ?");
    
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        memberList.remove(i);
        System.out.println("데이터를 삭제하였습니다.");
        return; 
      }
    }
      System.out.println("해당 번호의 데이터가 없습니다.");
  }
}

package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Input;

public class MemberHandler {

  private Member[] members = new Member[100];
  private int membersSize = 0;
  
  public Input input;
  public MemberHandler(Input input) {
    this.input = input;
  }
  
  public void listMember() {
    for (int i=0; i < membersSize; i++){
      Member member = members[i];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", 
          member.no, member.lectureName, member.email, member.pw, 
          member.pic, member.phoneNum, member.signedUpDate);
    }
  }



  public void addMember() {
    Member member = new Member();
    
    member.no = input.getIntValue("번호 ?");
    member.lectureName = input.getStringValue("이름? ");
    member.email = input.getStringValue("이메일? ");
    member.pw = input.getStringValue("암호? ");
    member.pic = input.getStringValue("사진? ");
    member.phoneNum = input.getStringValue("전화? ");
    member.signedUpDate = input.getDateValue("가입일? ");
    
    members[membersSize++] = member;
    System.out.println("저장하였습니다.");
  }
  
  
  

}

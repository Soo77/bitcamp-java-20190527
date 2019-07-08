package com.eomcs.lms;

import java.util.Scanner;

public class MemberHandler {
  static Member[] members = new Member[100];
  static int membersSize = 0;
  static Scanner keyScan;
  
    static void listMember() {
    for (int i=0; i < membersSize; i++){
      Member member = members[i];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n\n", 
          member.no, member.lectureName, member.email, member.pw, 
          member.pic, member.phoneNum, member.signedUpDate);
    }
  }

    static void addMember() {
    Member member = new Member();
    
    member.no = Input.getIntValue("번호 ?");
    member.lectureName = Input.getStringValue("이름? ");
    member.email = Input.getStringValue("이메일? ");
    member.pw = Input.getStringValue("암호? ");
    member.pic = Input.getStringValue("사진? ");
    member.phoneNum = Input.getStringValue("전화? ");
    member.signedUpDate = Input.getDateValue("가입일? ");
    
    members[membersSize++] = member;
    System.out.println("저장하였습니다.");
  }
}

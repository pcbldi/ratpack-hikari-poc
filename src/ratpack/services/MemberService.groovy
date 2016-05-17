package services

import models.Member
import db.DbConfig

class MemberService {

  public static Member createMember(def txn, Member member){
    return member;
  }

  public static Map validateMember(def txn, Member member){
    println txn.execute("Select count(*) from member where email='${member.email}'");
    def resp=txn.execute("Select count(*) from member where email='${member.email}'");

    [status:true]
  }

  public static Closure validateMember={Member member->

  }

  public static Member getMember(long id){

  }
}
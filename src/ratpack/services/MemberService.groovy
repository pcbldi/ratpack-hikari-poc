package services

import models.Member
import db.DbConfig
import db.Db

class MemberService {

  public static Member createMember(def txn, Member member){
    Db.create(txn,createQuery(member))
    return member;
  }

  public static Map validateMember(def txn, Member member){
    Long count=Db.read(txn,"Select count(*) from member where email='${member.email}';").flatten().first();

    [status:(count==0)]
  }

  public static Closure validateMember={Member member->

  }

  public static Member getMember(long id){

  }

  static String createQuery(Member member){
    return  """
Insert into Member
(email,first_name,last_name,mobile)
values
('$member.email', '$member.firstName', '$member.lastName','$member.mobile');
"""
  }
}
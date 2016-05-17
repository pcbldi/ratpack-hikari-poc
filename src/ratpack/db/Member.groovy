package db

class DbMember {

  public static Closure save={Member member->
    DbConfig.wrapinTransaction

  }
}
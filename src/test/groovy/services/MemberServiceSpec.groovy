package services

import spock.lang.Specification
import models.Member
import db.DbConfig

class MemberServiceSpec extends Specification {

  def "Saves a member in the db"() {
  given:
  Member member = new Member(email:"test1@test.com", firstName:"first", mobile: "98989898989898")
  when:
  Member createdMember
  DbConfig.wrapInTestTransaction { txn ->
    createdMember=MemberService.createMember(txn,member)
  }
  then:
  createdMember== member
  }
}

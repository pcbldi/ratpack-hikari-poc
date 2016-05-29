package models

import spock.lang.Specification
import models.Member

class MemberSpec extends Specification {

  def "Test Member name is working"() {
  when:
  Member member = new Member(email:"test1@test.com", firstName:"first", lastName:"last", mobile: "98989898989898")

  then:
  member.name== "first last"
  }

   def "Test Member name is firstName if lastName is null"() {
  when:
  Member member = new Member(email:"test1@test.com", firstName:"first", mobile: "98989898989898")

  then:
  member.name== member.firstName
  }

}

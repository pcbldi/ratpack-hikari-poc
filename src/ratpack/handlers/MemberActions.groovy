package handlers;

import ratpack.handling.Chain;
import ratpack.func.Action;
import ratpack.groovy.handling.GroovyChainAction
import static ratpack.jackson.Jackson.jsonNode
import static ratpack.jackson.Jackson.json
import services.MemberService
import db.DbConfig
import models.Member
import com.fasterxml.jackson.databind.*


class MemberActions extends GroovyChainAction{
  @Override
  void execute() throws Exception {
    path(":id") {
      byMethod {
	get() {
	}
	put() {}
	delete() {}
      }
    }
    path() {
      byMethod {
	get() {
	}
	put() {
	}
	delete() {}
	post(){
	  parse(jsonNode()).then{ body->
	    //todo: find alternative for json parsing and generation.
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> memberAsMap = mapper.convertValue(body, Map.class);
	    Map result = createMember(new Member(memberAsMap))
	    context.response.status(result.status).send(mapper.writeValueAsString(result.body))
	  }
	}
      }
    }
  }

  Map createMember(Member member) {
    DbConfig.wrapInTransaction { txn->
      Map validationResp= MemberService.validateMember(txn,member)
      if(validationResp.status) {
	Member savedMember = MemberService.createMember(txn,member)
	if(member) {
	  return [status: 201, body: member]
	}
	else{
	  return [status: 500, body : "something bad happened, please try again"]
	}
      }
      else {
	return [status: 400, body: validationResp.errors]
      }
    }
  }
}

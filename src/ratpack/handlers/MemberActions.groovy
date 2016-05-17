package handlers;

import ratpack.handling.Chain;
import ratpack.func.Action;
import ratpack.groovy.handling.GroovyChainAction

class MemberActions extends GroovyChainAction{
  @Override
  void execute() throws Exception {
    path(":id") {
      byMethod {
	get() {
	  render "this is ${id}"
	}
	put() {}
	delete() {}
      }
    }
  }
}
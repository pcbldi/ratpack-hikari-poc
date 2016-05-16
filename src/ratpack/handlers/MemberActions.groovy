package handlers;

import ratpack.handling.Chain;
import ratpack.func.Action;

class MemberActions implements Action<Chain> {
  @Override
  void execute(Chain chain) throws Exception {
    Groovy.chain(chain) {
      handler() {
	prefix(":id") {
	  byMethod {
	    get() {}
	    put() {}
	    delete() {}
	  }
	}
	byMethod {
	  get() {}
	  post() {}
	}
      }
    }
  }
}
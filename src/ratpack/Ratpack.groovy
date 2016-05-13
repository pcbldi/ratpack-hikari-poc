import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack
import db.DbConfig

ratpack {
  bindings {
    module MarkupTemplateModule
  }

  handlers {
    get {
      DbConfig.wrapInTransaction { txn ->
	println "inside closure"
	println txn;
	println "done";
      }
      render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    }

    files { dir "public" }
  }
}

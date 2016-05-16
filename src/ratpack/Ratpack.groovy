import static ratpack.groovy.Groovy.ratpack
import handlers.*

ratpack {
  handlers {
    prefix("books"){
      handler chain(registry.get(MemberActions))
    }
  }
}

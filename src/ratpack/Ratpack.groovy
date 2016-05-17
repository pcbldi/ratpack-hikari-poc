import static ratpack.groovy.Groovy.ratpack
import handlers.*

ratpack {
    handlers {
    prefix("books"){
      all chain(new MemberActions())
    }
  }
}

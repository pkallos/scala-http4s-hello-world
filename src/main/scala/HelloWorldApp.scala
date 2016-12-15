import org.http4s._, org.http4s.dsl._
import org.http4s.server.{Server, ServerApp}
import org.http4s.server.blaze._
import scalaz.concurrent.Task
import org.http4s.server.syntax._

object Main extends ServerApp {
  override def server(args: List[String]): Task[Server] = {
    val helloWorldService = HttpService {
      case GET -> Root =>
        Ok("Welcome")
    }
    BlazeBuilder
      .bindHttp(8080, "localhost")
      .mountService(helloWorldService, "/")
      .start
  }
}

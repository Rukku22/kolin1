package route

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.UserAllDetails
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import service.UserService.save

fun Application.Responsedata() {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    routing {

        post("/insert") {
            var body = call.receive<UserAllDetails>()
            var data = save(body)
            log.info("insert data:$body")
            if (!body.equals(0)) {
                call.respond(HttpStatusCode.OK, body)

            } else {
               call.respond("forbidden")
            }
        }
    }
}
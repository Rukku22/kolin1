package service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import model.UserAllDetails
import org.slf4j.LoggerFactory

object  UserService {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }}
        suspend fun save(body:UserAllDetails):List<UserAllDetails> {
        val log: org.slf4j.Logger = LoggerFactory.getLogger(javaClass)
        log.info("insert body$body")
        val insert: HttpResponse = client.post("https://api.gravty.me/v1/members/") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        return insert.body() as List<UserAllDetails>
    }
}
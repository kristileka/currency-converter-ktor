package com.kristileka.plugins

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Application.configureRouting() {
    val client = HttpClient(CIO) {

    }


    routing {
        get("/convert/{currency}/{value1}/{currency2}/{value2}") {
            GlobalScope.launch {
                val response: HttpResponse = client.request("https://ktor.io/") {
                    method = HttpMethod.Get
                }
                delay(2000)
                print(response)
            }
            return@get call.respondText { "asd" }
        }
    }
}

data class TestJson(var x: String)


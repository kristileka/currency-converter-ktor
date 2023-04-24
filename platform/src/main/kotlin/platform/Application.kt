package platform

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import platform.advice.configureAdvice
import platform.di.configureKoin
import platform.plugins.configureSerialization
import platform.routes.currencyRoutes
import platform.validation.configureValidation

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureAdvice()
    configureValidation()
    configureSerialization()
    routesConfig()
}

fun Application.routesConfig() {
    routing {
        currencyRoutes()
    }
}

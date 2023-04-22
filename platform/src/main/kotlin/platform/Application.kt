package platform

import core.di.coreModule
import platform.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin
import platform.di.platformModule
import platform.routes.currencyRoutes
import web.services.di.webServiceModule

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(
            webServiceModule,
            coreModule,
            platformModule
        )
    }
    configureSerialization()
    routesConfig()
}

fun Application.routesConfig() {
    routing {
        currencyRoutes()
    }
}
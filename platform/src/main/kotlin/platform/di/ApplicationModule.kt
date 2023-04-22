package platform.di

import core.di.coreModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import web.services.di.webServiceModule

fun Application.configureKoin() {
    install(Koin) {
        modules(
            webServiceModule,
            coreModule,
            platformModule,
        )
    }
}

package web.services.di

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import web.services.dataservice.CurrencyDataService
import web.services.dataservice.CurrencyDataServiceImpl
import web.services.env.WebServiceEnv

internal val dataServiceModule = module {
    single<CurrencyDataService> {
        CurrencyDataServiceImpl(get())
    }
    single<HttpClient> {
        val env: WebServiceEnv by inject()
        HttpClient(CIO) {
            defaultRequest {
                url(env.baseUrl)
                header("apiKey", env.apiKey)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 30000
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    },
                )
            }
        }
    }
}


val webServiceModule = module {
    includes(dataServiceModule)
}

package platform.di

import com.typesafe.config.ConfigFactory
import org.koin.dsl.module
import web.services.env.WebServiceEnv

internal val platformEnvModule = module {
    val config = ConfigFactory.load("application.conf")

    val key = config.getString("currency.key")
    val url = config.getString("currency.url")

    single<WebServiceEnv> {
        WebServiceEnv(key, url)
    }
}
val platformModule = module {
    includes(platformEnvModule)
}

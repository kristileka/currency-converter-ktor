package platform.di

import org.koin.dsl.module
import web.services.env.WebServiceEnv


internal val platformEnvModule = module {
    single<WebServiceEnv> {
        WebServiceEnv("gfki2Ot3GnxKCej0J1z8NTswvgnVyOR1","https://api.apilayer.com/exchangerates_data/")
    }
}
val platformModule = module {
    includes(platformEnvModule)
}


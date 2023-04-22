package core.di

import core.services.ConvertCurrencyServiceImpl
import core.services.GetCurrencyServiceImpl
import core.services.usecases.ConvertCurrencyService
import core.services.usecases.GetCurrencyService
import org.koin.dsl.module

internal val coreServiceModule = module {
    single<GetCurrencyService> {
        GetCurrencyServiceImpl(get())
    }

    single<ConvertCurrencyService> {
        ConvertCurrencyServiceImpl(get())
    }
}

val coreModule = module {
    includes(coreServiceModule)
}


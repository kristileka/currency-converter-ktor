package core.services

import core.services.usecases.ConvertCurrencyService
import web.services.dataservice.CurrencyDataService

class ConvertCurrencyServiceImpl(
    val currencyDataService: CurrencyDataService
) : ConvertCurrencyService {
    override suspend fun execute(): List<String> {
        return listOf()
    }
}
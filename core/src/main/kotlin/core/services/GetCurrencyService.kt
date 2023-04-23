package core.services

import core.services.usecases.GetCurrencyService
import web.services.dataservice.CurrencyDataService

class GetCurrencyServiceImpl(
    private val currencyDataService: CurrencyDataService
) : GetCurrencyService {
    override suspend fun execute(): List<String> {
        return currencyDataService.getSymbols().symbols.map {
            it.key
        }
    }
}
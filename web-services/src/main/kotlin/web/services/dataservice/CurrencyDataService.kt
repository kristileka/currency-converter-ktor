package web.services.dataservice

import web.services.model.request.ConvertCurrencyWSRequest
import web.services.model.response.ConvertCurrencyWSResponse
import web.services.model.response.GetSymbolResponse

interface CurrencyDataService {
    suspend fun getSymbols(): GetSymbolResponse
    suspend fun convert(convertCurrency: ConvertCurrencyWSRequest): ConvertCurrencyWSResponse
}

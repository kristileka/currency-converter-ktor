package web.services.dataservice

import web.services.model.request.ConvertCurrencyWSRequest
import web.services.model.response.ConvertCurrencyWSResponse
import web.services.model.response.GetSymbolResponseWS

interface CurrencyDataService {
    suspend fun getSymbols(): GetSymbolResponseWS
    suspend fun convert(convertCurrency: ConvertCurrencyWSRequest): ConvertCurrencyWSResponse
}

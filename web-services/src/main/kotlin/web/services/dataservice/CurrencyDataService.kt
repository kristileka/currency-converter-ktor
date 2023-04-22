package web.services.dataservice

import web.services.model.request.ConvertCurrencyRequest
import web.services.model.response.GetSymbolResponse

interface CurrencyDataService {
    suspend fun getSymbols(): GetSymbolResponse
    suspend fun convert(convertCurrency: ConvertCurrencyRequest): List<GetSymbolResponse>
}
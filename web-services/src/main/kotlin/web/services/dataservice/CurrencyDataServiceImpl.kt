package web.services.dataservice

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import web.services.env.WebServiceEnv
import web.services.model.request.ConvertCurrencyRequest
import web.services.model.response.GetSymbolResponse

class CurrencyDataServiceImpl(
    private val webServiceEnv: WebServiceEnv,
    private val client: HttpClient
) : CurrencyDataService {

    companion object {
        const val SYMBOLS_OPERATION = "symbols"
        const val CONVERT_OPERATION = "convert"
    }


    override suspend fun getSymbols(): GetSymbolResponse {
        val symbols: GetSymbolResponse = client.request(webServiceEnv.baseUrl + SYMBOLS_OPERATION) {
            method = HttpMethod.Get
            headers {
                append("apiKey", webServiceEnv.apiKey)
            }
        }.body()
        return symbols
    }

    override suspend fun convert(convertCurrency: ConvertCurrencyRequest): List<GetSymbolResponse> {
        TODO("Not yet implemented")
    }
}
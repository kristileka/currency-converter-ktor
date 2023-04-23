package web.services.dataservice

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import web.services.model.exception.WebServicesException
import web.services.model.request.ConvertCurrencyWSRequest
import web.services.model.response.ConvertCurrencyWSResponse
import web.services.model.response.GetSymbolResponseWS
import web.services.model.response.WebServiceError

class CurrencyDataServiceImpl(
    private val client: HttpClient,
) : CurrencyDataService {

    companion object {
        const val SYMBOLS_OPERATION = "symbols"
        const val CONVERT_OPERATION = "convert"
    }

    override suspend fun getSymbols(): GetSymbolResponseWS {
        return client.request(SYMBOLS_OPERATION) {
            method = HttpMethod.Get
            contentType(ContentType.Application.Json)
        }.body<GetSymbolResponseWS>()
    }

    override suspend fun convert(convertCurrency: ConvertCurrencyWSRequest): ConvertCurrencyWSResponse {
        val response: HttpResponse = client.get(CONVERT_OPERATION) {
            url {
                parameters.append("from", convertCurrency.from)
                parameters.append("to", convertCurrency.to)
                parameters.append("amount", convertCurrency.amount.toString())
            }
        }
        val statusCode = response.status
        return if (statusCode == HttpStatusCode.OK) {
            response.body<ConvertCurrencyWSResponse>()
        } else {
            try {
                val content = response.bodyAsText()
                val error = Gson().fromJson(content, WebServiceError::class.java)
                throw WebServicesException(error.error.message, statusCode)
            } catch (ex: Exception) {
                throw WebServicesException(ex.message ?: "Error parsing error. Contact Developer.", statusCode)
            }
        }
    }
}

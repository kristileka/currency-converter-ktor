package web.services.dataservice

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import web.services.model.request.ConvertCurrencyWSRequest
import web.services.model.response.ConvertCurrencyWSResponse
import web.services.model.response.GetSymbolResponseWS

class CurrencyDataServiceImplTest {
    private fun <T> buildMockEngine(t: T) = MockEngine {
        respond(
            content = ByteReadChannel(Gson().toJson(t)),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private fun buildClient(mockEngine: MockEngine) = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            gson()
        }
    }

    private lateinit var currencyDataService: CurrencyDataService

    @Test
    fun getSymbols() {
        val clientResponse = GetSymbolResponseWS(true, mapOf("USD" to "USD NAME"))
        val client = buildClient(buildMockEngine(clientResponse))
        currencyDataService = CurrencyDataServiceImpl(client)
        val currencies = runBlocking { currencyDataService.getSymbols() }
        assertTrue(currencies.success)
        assertEquals(currencies.symbols["USD"], "USD NAME")
    }

    @Test
    fun convert() {
        val clientResponse = ConvertCurrencyWSResponse(null, null, null, 2.2, true)
        val client = buildClient(buildMockEngine(clientResponse))
        currencyDataService = CurrencyDataServiceImpl(client)
        val responseWS = runBlocking { currencyDataService.convert(ConvertCurrencyWSRequest("asd", "asd", 1.0)) }
        assertNotNull(responseWS.success)
        assertTrue(responseWS.success!!)
        assertEquals(
            clientResponse.result, responseWS.result
        )
    }
}
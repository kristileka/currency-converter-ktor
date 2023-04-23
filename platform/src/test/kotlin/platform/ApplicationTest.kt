package platform

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import io.ktor.client.plugins.contentnegotiation.*

import platform.rest.request.ConvertCurrencyRequestREST
import platform.rest.response.ConvertCurrencyResponseREST
import platform.rest.response.ExceptionResponse
import platform.rest.response.GetCurrenciesREST
import kotlin.test.*

class ApplicationTest {

    companion object {
        private const val BASE_URL: String = "/api/v1/currency/"
        private const val GET_CURRENCY = BASE_URL + "all"
        private const val CONVERT_CURRENCY = BASE_URL + "convert"
    }

    @Test
    fun `get currencies succesfully`() {
        testApplication {
            application {
                module()
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val response = client.get(GET_CURRENCY)
            assertEquals(HttpStatusCode.OK, response.status)
            val getCurrenciesRest = response.body<GetCurrenciesREST>()
            assert(getCurrenciesRest.total > 100)
            assert(getCurrenciesRest.result.contains("USD"))
            assert(getCurrenciesRest.result.contains("EUR"))
        }
    }


    @Test
    fun `convert currency fails`() {
        testApplication {
            application {
                module()
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val body = ConvertCurrencyRequestREST("ASD", "USD", 5.0)
            val response = client.post(CONVERT_CURRENCY) {
                setBody(body)
                headers {
                    append("content-type", "application/json")
                }
            }
            assertEquals(HttpStatusCode.BadRequest, response.status)
            val errorResponse = response.body<ExceptionResponse>()
            assertEquals(errorResponse.code, HttpStatusCode.BadRequest.value)
        }
    }

    @Test
    fun `convert currency success`() {
        testApplication {
            application {
                module()
            }
            val client = createClient {
                install(ContentNegotiation) {
                    json()
                }
            }
            val body = ConvertCurrencyRequestREST("ALL", "USD", 5.0)
            val response = client.post(CONVERT_CURRENCY) {
                setBody(body)
                headers {
                    append("content-type", "application/json")
                }
            }
            assertEquals(HttpStatusCode.OK, response.status)
            val getCurrenciesRest = response.body<ConvertCurrencyResponseREST>()
            assertEquals(getCurrenciesRest.currencyTo, body.convertToCurrency)
            assertEquals(getCurrenciesRest.currencyFrom, body.convertFromCurrency)
            assertEquals(getCurrenciesRest.currencyFromAmount, body.convertFromAmount)
        }
    }
}
package core.services

import core.dto.ConvertCurrencyDTO
import core.services.usecases.ConvertCurrencyService
import io.ktor.http.*
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import web.services.dataservice.CurrencyDataService
import web.services.model.exception.WebServicesException
import web.services.model.request.ConvertCurrencyWSRequest
import web.services.model.response.ConvertCurrencyWSResponse

class ConvertCurrencyServiceImplTest {

    @MockK
    var currencyDataService: CurrencyDataService = mockk()

    private lateinit var convertCurrencyService: ConvertCurrencyService

    @BeforeEach
    fun init() {
        convertCurrencyService = ConvertCurrencyServiceImpl(currencyDataService)
    }


    @Test
    fun `convert currency failure`() {
        coEvery {
            currencyDataService.convert(any())
        } throws WebServicesException("Error parsing error. Contact Developer.", HttpStatusCode.BadRequest)
        val request = ConvertCurrencyDTO("USD", 1.2, "Test")
        assertThrows(WebServicesException::class.java) {
            runBlocking { convertCurrencyService.execute(request) }
        }
    }

    @Test
    fun `convert currency success`() {
        coEvery {
            currencyDataService.convert(any())
        } throws WebServicesException("Error parsing error. Contact Developer.", HttpStatusCode.BadRequest)
        val request = ConvertCurrencyDTO("USD", 1.2, "Test")
        val response = runBlocking { convertCurrencyService.execute(request) }
        assertEquals(1.2, response.second)
    }
}
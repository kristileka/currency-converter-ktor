package core.services

import core.services.usecases.GetCurrencyService
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import web.services.dataservice.CurrencyDataService
import web.services.model.response.GetSymbolResponseWS

class GetCurrencyServiceImplTest {
    @MockK
    var currencyDataService: CurrencyDataService = mockk()

    private lateinit var getCurrencyService: GetCurrencyService

    @BeforeEach
    fun init() {
        getCurrencyService = GetCurrencyServiceImpl(currencyDataService)
    }

    @Test
    fun `convert currency failure`() {
        coEvery {
            currencyDataService.getSymbols()
        } returns GetSymbolResponseWS(true, mapOf("USD" to "USD"))
        val response = runBlocking { getCurrencyService.execute() }
        assertEquals(response.size, 1)
        assertEquals("USD", response.first())
    }
}
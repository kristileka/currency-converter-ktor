package platform.rest.response

import core.dto.ConvertCurrencyDTO
import kotlinx.serialization.Serializable

@Serializable
data class ConvertCurrencyResponseREST(
    val currencyFrom: String,
    val currencyTo: String,
    val currencyFromAmount: Double,
    val convertedAmount: Double,
) {
    companion object {
        fun fromCore(request: ConvertCurrencyDTO, amount: Double) = ConvertCurrencyResponseREST(
            request.currencyFromCurrency,
            request.currencyToCurrency,
            request.currencyFromAmount,
            amount,
        )
    }
}

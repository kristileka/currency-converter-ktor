package platform.rest.response

import core.dto.ConvertCurrencyDTO
import kotlinx.serialization.Serializable

@Serializable
data class ConvertCurrencyREST(
    val currencyFrom: String,
    val currencyTo: String,
    val currencyFromAmount: Double,
    val currencyToAmount: Double,
) {
    companion object {
        fun fromCore(request: ConvertCurrencyDTO, amount: Double) = ConvertCurrencyREST(
            request.currencyFromCurrency,
            request.currencyFromCurrency,
            request.currencyFromAmount,
            amount,
        )
    }
}

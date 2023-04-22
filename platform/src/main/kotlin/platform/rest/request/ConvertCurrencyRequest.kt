package platform.rest.request

import core.dto.ConvertCurrencyDTO
import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class ConvertCurrencyRequest(
    val convertFromCurrency: String?,
    val convertToCurrency: String?,
    val convertFromAmount: Double?,
) {
    companion object {
        fun ConvertCurrencyRequest.toCore(): ConvertCurrencyDTO = ConvertCurrencyDTO(
            this.convertToCurrency!!,
            this.convertFromAmount!!,
            this.convertFromCurrency!!,
        )
    }
}

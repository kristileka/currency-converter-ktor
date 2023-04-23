package platform.rest.request

import core.dto.ConvertCurrencyDTO
import kotlinx.serialization.Serializable

@Serializable
data class ConvertCurrencyRequestREST(
    val convertFromCurrency: String?,
    val convertToCurrency: String?,
    val convertFromAmount: Double?,
) {
    companion object {
        fun ConvertCurrencyRequestREST.toCore(): ConvertCurrencyDTO = ConvertCurrencyDTO(
            this.convertToCurrency!!,
            this.convertFromAmount!!,
            this.convertFromCurrency!!,
        )
    }
}

package core.dto

import web.services.model.request.ConvertCurrencyWSRequest

data class ConvertCurrencyDTO(
    val currencyToCurrency: String,
    val currencyFromAmount: Double,
    val currencyFromCurrency: String,
) {
    companion object {
        fun ConvertCurrencyDTO.toWS(): ConvertCurrencyWSRequest = ConvertCurrencyWSRequest(
            this.currencyFromCurrency,
            this.currencyToCurrency,
            this.currencyFromAmount,
        )
    }
}

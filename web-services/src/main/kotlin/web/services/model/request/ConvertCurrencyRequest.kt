package web.services.model.request

data class ConvertCurrencyRequest(
    val currencyFrom: String,
    val currencyTo: String,
    val currencyFromValue: Int
)

package platform.rest

data class ConvertCurrencyREST(
    val currencyFrom: String,
    val currencyTo: String,
    val currentFromValue: Long,
    val currencyToValue: Long,
)

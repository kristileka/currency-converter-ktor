package web.services.model.request

data class ConvertCurrencyWSRequest(
    val from: String,
    val to: String,
    val amount: Double,
)

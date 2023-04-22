package web.services.model.response

data class ConvertCurrencyResponse(
    val error: Error? = null,
    val date: String? = null,
    val info: Info? = null,
    val query: Query? = null,
    val result: Double? = null,
    val success: Boolean? = null
)

data class Error(
    val code: String, val message: String
)

data class Info(
    val rate: Double, val timestamp: Int
)

data class Query(
    val amount: Int, val from: String, val to: String
)
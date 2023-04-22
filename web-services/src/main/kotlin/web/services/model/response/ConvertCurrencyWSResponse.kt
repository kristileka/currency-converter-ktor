package web.services.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ConvertCurrencyWSResponse(
    val date: String? = null,
    val info: Info? = null,
    val query: Query? = null,
    val result: Double? = null,
    val success: Boolean? = null,
)
@Serializable
data class Info(
    val rate: Double,
    val timestamp: Int,
)

@Serializable
data class Query(
    val amount: Double,
    val from: String,
    val to: String,
)

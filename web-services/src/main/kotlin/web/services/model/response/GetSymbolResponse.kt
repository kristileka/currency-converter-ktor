package web.services.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetSymbolResponse(
    val success: Boolean,
    val symbols: Map<String, String>
)

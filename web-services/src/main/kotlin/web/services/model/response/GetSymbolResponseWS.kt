package web.services.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetSymbolResponseWS(
    val success: Boolean,
    val symbols: Map<String, String>,
)

package web.services.model.response

import kotlinx.serialization.Serializable

@Serializable
data class WebServiceError(
    val error: Error,
)

@Serializable
data class Error(
    val code: String,
    val message: String,
)

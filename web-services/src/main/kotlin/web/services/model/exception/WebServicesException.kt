package web.services.model.exception

import io.ktor.http.*

data class WebServicesException(
    override val message: String,
    val httpStatusCode: HttpStatusCode,
) : Throwable()

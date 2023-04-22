package platform.advice

import core.exceptions.CoreErrorException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import platform.rest.response.ExceptionResponse
import web.services.model.exception.WebServicesException

fun Application.configureAdvice() {
    install(StatusPages) {
        exception<RequestValidationException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ExceptionResponse("${cause.message}", HttpStatusCode.BadRequest.value),
            )
        }
        exception<Throwable> { call, throwable ->
            when (throwable) {
                is CoreErrorException -> call.respond(
                    HttpStatusCode.BadRequest,
                    ExceptionResponse(throwable.message, HttpStatusCode.BadRequest.value),
                )

                is WebServicesException -> call.respond(
                    throwable.httpStatusCode,
                    ExceptionResponse(throwable.message, throwable.httpStatusCode.value),
                )

                else -> call.respond(
                    HttpStatusCode.InternalServerError,
                    ExceptionResponse(
                        throwable.message ?: "Unknown error. Please contact developer.",
                        HttpStatusCode.InternalServerError.value,
                    ),
                )
            }
        }
        status(
            HttpStatusCode.UnsupportedMediaType
        ) { call, _ ->
            call.respond(
                HttpStatusCode.BadRequest,
                ExceptionResponse("Please provide proper request body.", HttpStatusCode.BadRequest.value),
            )
        }
    }

}


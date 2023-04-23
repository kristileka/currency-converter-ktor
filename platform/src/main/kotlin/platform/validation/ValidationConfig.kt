package platform.validation

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import platform.rest.request.ConvertCurrencyRequest

fun Application.configureValidation() {
    install(RequestValidation) {
        validate<ConvertCurrencyRequest> { request ->
            if (request.convertFromAmount == null || request.convertFromAmount <= 0) {
                ValidationResult.Invalid("'convertFromAmount' cannot be smaller or equal to 0")
            } else if (request.convertToCurrency.isNullOrBlank()) {
                ValidationResult.Invalid("'convertToCurrency' cannot be blank")
            } else if (request.convertFromCurrency.isNullOrBlank()) {
                ValidationResult.Invalid("'convertFromCurrency' cannot be blank")
            } else ValidationResult.Valid
        }
    }
}

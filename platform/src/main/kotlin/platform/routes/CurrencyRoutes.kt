package platform.routes

import core.services.usecases.ConvertCurrencyService
import core.services.usecases.GetCurrencyService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import platform.rest.request.ConvertCurrencyRequest
import platform.rest.request.ConvertCurrencyRequest.Companion.toCore
import platform.rest.response.ConvertCurrencyREST
import platform.rest.response.GetCurrenciesREST

internal fun Routing.currencyRoutes() {
    route("/v1/currency") {
        getCurrencies()
        convertCurrency()
    }
}

private fun Route.getCurrencies() {
    val getCurrenciesService by inject<GetCurrencyService>()
    get("/all") {
        call.respond(
            GetCurrenciesREST.fromCurrencies(getCurrenciesService.execute()),
        )
    }
}

private fun Route.convertCurrency() {
    val convertCurrencyService by inject<ConvertCurrencyService>()
    post("/convert") {
        val request = call.receive<ConvertCurrencyRequest>()
        val (response, responseAmount) = convertCurrencyService.execute(request.toCore())
        call.respond(ConvertCurrencyREST.fromCore(response, responseAmount))
    }
}

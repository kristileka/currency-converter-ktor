package platform.routes

import core.services.usecases.ConvertCurrencyService
import core.services.usecases.GetCurrencyService
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject


internal fun Routing.currencyRoutes() {
    route("/v1/currency") {
        getCurrencies()
        convertCurrency()
    }
}

private fun Route.getCurrencies() {
    val getCurrenciesService by inject<GetCurrencyService>()
    get("/all") {
        call.respond(getCurrenciesService.execute())
    }
}

private fun Route.convertCurrency() {
    val convertCurrencyService by inject<ConvertCurrencyService>()
    post("/convert") {
        call.respond(convertCurrencyService.execute())
    }
}

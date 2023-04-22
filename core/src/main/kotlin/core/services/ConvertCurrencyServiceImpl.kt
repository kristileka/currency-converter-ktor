package core.services

import core.dto.ConvertCurrencyDTO
import core.dto.ConvertCurrencyDTO.Companion.toWS
import core.exceptions.CoreDataErrorException
import core.services.usecases.ConvertCurrencyService
import web.services.dataservice.CurrencyDataService

class ConvertCurrencyServiceImpl(
    private val currencyDataService: CurrencyDataService,
) : ConvertCurrencyService {
    override suspend fun execute(request: ConvertCurrencyDTO): Pair<ConvertCurrencyDTO, Double> {
        val data = currencyDataService.convert(
            request.toWS(),
        )
        val amount = data.result ?: throw CoreDataErrorException()
        return Pair(request, amount)
    }
}

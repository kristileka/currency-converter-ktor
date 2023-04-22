package core.services.usecases

import core.dto.ConvertCurrencyDTO

interface GetCurrencyService {
    suspend fun execute(): List<String>
}

interface ConvertCurrencyService {
    suspend fun execute(request: ConvertCurrencyDTO): Pair<ConvertCurrencyDTO, Double>
}

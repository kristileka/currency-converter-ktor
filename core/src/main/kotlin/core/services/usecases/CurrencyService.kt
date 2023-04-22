package core.services.usecases


interface GetCurrencyService {
    suspend fun execute(): List<String>
}

interface ConvertCurrencyService {
    suspend fun execute(): List<String>
}
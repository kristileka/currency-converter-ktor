package platform.rest.response

data class GetCurrenciesREST(
    val result: List<String>,
    val total: Int,
) {
    companion object {
        fun fromCurrencies(result: List<String>): GetCurrenciesREST {
            return GetCurrenciesREST(result, result.size)
        }
    }
}

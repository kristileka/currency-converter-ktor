# KTOR Currency Converter

This backend rest api project provides apis to do operations with currencies. It is built using a small stack of
technology:

- [KTOR](https://ktor.io) as a Kotlin framework for REST API and Ktor Client to retrieve the currency informat
- [Kotlin Gradle](https://kotlinlang.org/docs/gradle.html) to help with architecture and build the project modularized
- [Koin](https://insert-koin.io/) to implement Dependency Injection throughout the application.
- [Mockk](https://mockk.io/) to test the ktor scenarios.

## Usage

This application exposes 2 apis:

```
GET - /api/v1/currency/all
```
This provides the list of the currencies, that are supported by our provider, and can be used to convert of any
positive amount.
```
POST - /api/v1/currency/convert
{
    "convertFromCurrency":"USD",
    "convertToCurrency":"EUR",
    "convertFromAmount":1.0
}
```

This api will return the converted amount for the selected currency or an exception of the error if one was made. It
requests the current conversion to a provider and maps it to a simpler way.

## Testing

To ensure that the business logic is correct, The application tests the core and data logic as Unit tests, and the platform
apis using Integration test.(Currently Tests need to be added for higher coverage but base idea is made)

## Running

To run the app is pretty straight forward. You need to run the main application in platform using the main function, and 
everything will be setup for you.

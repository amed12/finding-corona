package com.sun3toline.fico.data.network.models

object DummyCountry {
    fun generateDummy(): List<CountryResponse.Country> {
        val list = arrayListOf<CountryResponse.Country>()
        list.add(
            CountryResponse.Country(
                "indonesia",
                4242424,
                23213,
                123213,
                "indonesia",
                123123,
                21312321,
                12312312
            )
        )
        list.add(
            CountryResponse.Country(
                "indonesia2",
                4242424,
                23213,
                123213,
                "indonesia",
                123123,
                21312321,
                12312312
            )
        )
        list.add(
            CountryResponse.Country(
                "indonesia3",
                4242424,
                23213,
                123213,
                "indonesia",
                123123,
                21312321,
                12312312
            )
        )
        return list
    }
}
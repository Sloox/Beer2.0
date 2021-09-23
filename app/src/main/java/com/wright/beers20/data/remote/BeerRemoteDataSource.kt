package com.wright.beers20.data.remote

import com.wright.beers20.data.model.Beer
import com.wright.beers20.data.services.BeerService
import retrofit2.awaitResponse

class BeerRemoteDataSource(
    private val beerService: BeerService
) : BeerRemoteSource {
    override suspend fun getABeerByID(ID: Int): Beer {
        val response = beerService.getABeerByID(id = ID).awaitResponse()
        return response.body()?.first() ?: Beer()
    }

    override suspend fun getBeersList(): List<Beer> {
        val response = beerService.getBeers().awaitResponse()
        return response.body() ?: listOf()
    }
}

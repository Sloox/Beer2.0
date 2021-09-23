package com.wright.beers20.data.repositories

import com.wright.beers20.data.remote.BeerRemoteSource
import com.wright.beers20.domain.interfaces.BeersRepository

class BeersDataRepository(
    private val beerRemoteSource: BeerRemoteSource
) : BeersRepository {
    override suspend fun getABeer(ID: Int) = beerRemoteSource.getABeerByID(ID)
    override suspend fun getBeerList() = beerRemoteSource.getBeersList()
}

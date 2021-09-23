package com.wright.beers20.data.remote

import com.wright.beers20.data.model.Beer

interface BeerRemoteSource {
    suspend fun getABeerByID(ID: Int): Beer
    suspend fun getBeersList(): List<Beer>
}

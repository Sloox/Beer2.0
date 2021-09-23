package com.wright.beers20.domain.interfaces

import com.wright.beers20.data.model.Beer

interface BeersRepository {
    suspend fun getABeer(ID: Int): Beer
    suspend fun getBeerList(): List<Beer>
}

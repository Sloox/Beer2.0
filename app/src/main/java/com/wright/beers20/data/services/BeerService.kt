package com.wright.beers20.data.services

import com.wright.beers20.data.model.Beer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerService {
    @GET("beers/{id}")
    fun getABeerByID(@Path("id") id: Int): Call<List<Beer>>

    @GET("beers")
    fun getBeers(): Call<List<Beer>>
}

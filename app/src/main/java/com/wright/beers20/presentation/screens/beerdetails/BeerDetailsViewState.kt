package com.wright.beers20.presentation.screens.beerdetails

import com.wright.beers20.commons.ViewState
import com.wright.beers20.data.model.Beer

data class BeerDetailsViewState(val beer: Beer) : ViewState

fun providesInitialBeerDetailsViewState() = BeerDetailsViewState(Beer())

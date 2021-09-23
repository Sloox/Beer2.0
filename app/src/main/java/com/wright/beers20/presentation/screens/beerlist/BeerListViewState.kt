package com.wright.beers20.presentation.screens.beerlist

import com.wright.beers20.commons.ViewState
import com.wright.beers20.data.model.Beer

data class BeerListViewState(val beerList: List<Beer>) : ViewState

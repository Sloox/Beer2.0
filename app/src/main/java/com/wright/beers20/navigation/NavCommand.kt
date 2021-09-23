package com.wright.beers20.navigation

import androidx.annotation.IdRes
import com.wright.beers20.R

sealed class NavCommand(@IdRes val navigationId: Int) {
    object Back : NavCommand(-1)
    object BeerListFragment : NavCommand(R.id.beerListFragment)
    data class BeerDetailsFragment(val beerID: Int) : NavCommand(R.id.beerDetailsFragment)
}

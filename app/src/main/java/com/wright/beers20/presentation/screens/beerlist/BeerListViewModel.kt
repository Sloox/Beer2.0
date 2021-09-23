package com.wright.beers20.presentation.screens.beerlist

import android.util.Log
import com.wright.beers20.commons.BaseViewModel
import com.wright.beers20.commons.UseCaseExecutor
import com.wright.beers20.domain.usecases.BeerListUseCase
import com.wright.beers20.navigation.NavCommand.BeerDetailsFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val beerListUseCase: BeerListUseCase,
    private val useCaseExecutor: UseCaseExecutor,
    private val coroutineScope: CoroutineScope
) : BaseViewModel<BeerListViewState>() {
    override fun initialState(): BeerListViewState = BeerListViewState(arrayListOf())

    override fun onStart() {
        useCaseExecutor.execute(
            beerListUseCase,
            Unit,
            { updateState(BeerListViewState(it)) },
            { Log.e("error", "onStart: ${it.localizedMessage}") },
            coroutineScope
        )
    }

    fun navigateRandomly() {
        val randomBeer = currentViewState().beerList.random().id ?: 0
        navigate(BeerDetailsFragment(randomBeer))
    }

    override fun onDestroy() = Unit
}

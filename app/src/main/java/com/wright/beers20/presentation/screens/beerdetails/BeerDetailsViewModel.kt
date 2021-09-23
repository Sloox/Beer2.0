package com.wright.beers20.presentation.screens.beerdetails

import android.util.Log
import com.wright.beers20.commons.BaseViewModel
import com.wright.beers20.commons.UseCaseExecutor
import com.wright.beers20.data.model.Beer
import com.wright.beers20.domain.usecases.SingleBeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(
    private val singleBeerUseCase: SingleBeerUseCase,
    private val useCaseExecutor: UseCaseExecutor,
    private val coroutineScope: CoroutineScope
) : BaseViewModel<BeerDetailsViewState>() {
    override fun initialState(): BeerDetailsViewState = providesInitialBeerDetailsViewState()
    override fun onStart() = Unit

    fun onStartWithNavArguments(beerId: Int) {
        useCaseExecutor.execute(
            singleBeerUseCase,
            beerId,
            ::onSuccessFullBeerRetrieval,
            ::onBeerFailure,
            coroutineScope
        )
    }

    private fun onBeerFailure(exception: Exception) {
        Log.e("BeerDetailsViewModel", "onBeerFailure: $exception")
    }

    private fun onSuccessFullBeerRetrieval(beer: Beer) {
        updateState(BeerDetailsViewState(beer))
    }

    override fun onDestroy() = Unit
}

package com.wright.beers20.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wright.beers20.navigation.NavCommand
import com.wright.beers20.util.SingleLiveEvent

abstract class BaseViewModel<VIEW_STATE : ViewState> : ViewModel() {

    private val _viewState = MutableLiveData<VIEW_STATE>().apply { value = initialState() }

    abstract fun initialState(): VIEW_STATE
    abstract fun onStart()
    abstract fun onDestroy()

    val viewState: LiveData<VIEW_STATE>
        get() = _viewState

    val navCommand = SingleLiveEvent<NavCommand>()

    fun currentViewState() = viewState.value ?: initialState()

    fun updateState(newViewState: VIEW_STATE) {
       _viewState.postValue(newViewState)
    }

    fun navigate(navCommand: NavCommand) = this.navCommand.postValue(navCommand)
}

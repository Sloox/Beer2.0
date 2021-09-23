package com.wright.beers20.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wright.beers20.commons.UseCaseExecutor
import com.wright.beers20.data.model.Beer
import com.wright.beers20.domain.usecases.SingleBeerUseCase
import com.wright.beers20.presentation.screens.beerdetails.BeerDetailsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class BeerDetailsViewModelTest {
    private lateinit var classUnderTest: BeerDetailsViewModel

    @Mock
    private lateinit var singleBeerUseCase: SingleBeerUseCase

    @Mock
    private lateinit var useCaseExecutor: UseCaseExecutor

    @Mock
    private lateinit var coroutineScope: CoroutineScope

    @Before
    fun setup() {
        classUnderTest = BeerDetailsViewModel(singleBeerUseCase, useCaseExecutor, coroutineScope)
    }

    @get:Rule
    val mockitoRule: MethodRule = MockitoJUnit.rule()

    @get:Rule // -> allows liveData to work on different thread besides main, must be public!
    var executorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun `Given valid Nav arguments when onStartWithNavArgs then verify that SingleBeerUseCase is invoked`() {
        runBlocking {
            given(singleBeerUseCase.execute(1)).willReturn(Beer())
            classUnderTest.onStartWithNavArguments(1)
            //need to mock UseCaseExecutor to acutally interface with the usecase
            verify(useCaseExecutor).execute(eq(singleBeerUseCase), eq(1), any(), any(), eq(coroutineScope))
        }
    }
}

package com.wright.beers20.repository

import com.wright.beers20.data.model.Beer
import com.wright.beers20.data.remote.BeerRemoteSource
import com.wright.beers20.data.repositories.BeersDataRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class BeersDataRepositoryTest {
    private lateinit var classUnderTest: BeersDataRepository

    @Mock
    private lateinit var beerRemoteSource: BeerRemoteSource

    private val returnedBeer = Beer()
    private val returnedBeerList = arrayListOf(returnedBeer, returnedBeer)

    @Before
    fun setup() {
        classUnderTest = BeersDataRepository(beerRemoteSource)
    }

    @Test
    fun `when given a beer ID then return a valid beer with matching beer ID`() {
        runBlocking {
            given(beerRemoteSource.getABeerByID(1)).willReturn(returnedBeer)
            val answer = classUnderTest.getABeer(1)
            assert(answer.id == returnedBeer.id)
        }
    }

    @Test
    fun `when requesting a list of beers then return a valid list of beers`() {
        runBlocking {
            given(beerRemoteSource.getBeersList()).willReturn(returnedBeerList)
            val answer = classUnderTest.getBeerList()
            assert(answer.size == returnedBeerList.size)
            verify(beerRemoteSource).getBeersList()
        }
    }


}

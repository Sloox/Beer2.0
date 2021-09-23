package com.wright.beers20.usecases

import com.wright.beers20.data.model.Beer
import com.wright.beers20.domain.interfaces.BeersRepository
import com.wright.beers20.domain.usecases.SingleBeerUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given

@RunWith(MockitoJUnitRunner::class)
class SingleBeerUseCaseTest {

    private lateinit var classUnderTest: SingleBeerUseCase

    @Mock
    private lateinit var beersRepository: BeersRepository

    @Before
    fun setup() {
        classUnderTest = SingleBeerUseCase(beersRepository)
    }

    private val returnedBeer = Beer()

    @Test
    fun `Given a valid beer ID when SingleBeerUseCase is invoked return a valid beer`() {
        runBlocking {
            given(beersRepository.getABeer(1)).willReturn(returnedBeer)
            val result = classUnderTest.execute(1)
            assert(result == Beer().also { it.abv = 1.1 })
        }
    }

}

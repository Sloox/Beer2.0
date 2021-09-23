package com.wright.beers20.di.module

import com.wright.beers20.commons.IOCoroutineScope
import com.wright.beers20.commons.UseCaseExecutor
import com.wright.beers20.data.remote.BeerRemoteDataSource
import com.wright.beers20.data.remote.BeerRemoteSource
import com.wright.beers20.data.repositories.BeersDataRepository
import com.wright.beers20.data.services.BeerService
import com.wright.beers20.data.services.BeerServiceGenerator
import com.wright.beers20.domain.interfaces.BeersRepository
import com.wright.beers20.domain.usecases.BeerListUseCase
import com.wright.beers20.domain.usecases.SingleBeerUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class BeerModule {
    @Provides
    @Reusable
    fun providesBeerService(): BeerService = BeerServiceGenerator.createService(BeerService::class.java)

    @Provides
    @Reusable
    fun providesBeerRemoteSource(
        beerService: BeerService
    ): BeerRemoteSource = BeerRemoteDataSource(beerService)

    @Provides
    @Reusable
    fun providesBeerRepository(
        beerRemoteSource: BeerRemoteSource
    ): BeersRepository = BeersDataRepository(
        beerRemoteSource
    )

    @Provides
    @Reusable
    fun providesSingleBeerUseCase(
        beersRepository: BeersRepository
    ): SingleBeerUseCase = SingleBeerUseCase(beersRepository)

    @Provides
    @Reusable
    fun providesBeerListUseCase(
        beersRepository: BeersRepository
    ): BeerListUseCase = BeerListUseCase(beersRepository)

    @Provides
    @Reusable
    fun providesUseCaseExecutor(): UseCaseExecutor = UseCaseExecutor

    @Provides
    @Reusable
    fun providesCoroutineScope(): CoroutineScope = IOCoroutineScope()
}

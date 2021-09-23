package com.wright.beers20.domain.usecases

import com.wright.beers20.commons.BaseUseCase
import com.wright.beers20.data.model.Beer
import com.wright.beers20.domain.interfaces.BeersRepository

class BeerListUseCase(
    private val beersRepository: BeersRepository
) : BaseUseCase<Unit, List<Beer>> {
    override suspend fun execute(request: Unit) = beersRepository.getBeerList()
}

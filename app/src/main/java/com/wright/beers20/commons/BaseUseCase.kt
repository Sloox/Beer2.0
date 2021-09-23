package com.wright.beers20.commons

interface BaseUseCase<REQUEST, RETURN> {
    suspend fun execute(request: REQUEST): RETURN
}

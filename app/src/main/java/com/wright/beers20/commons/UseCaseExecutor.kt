package com.wright.beers20.commons

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object UseCaseExecutor {
    fun <REQUEST, RETURN> execute(
        useCase: BaseUseCase<REQUEST, RETURN>,
        requestValue: REQUEST,
        callBack: (RETURN) -> Unit,
        errorCallback: (Exception) -> Unit,
        coroutineScope: CoroutineScope
    ) = coroutineScope.launch {
        try {
            val returnVal = useCase.execute(requestValue)
            callBack(returnVal)
        } catch (e: Exception) {
            errorCallback(e)
        }
    }
}

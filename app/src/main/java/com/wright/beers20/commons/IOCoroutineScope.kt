package com.wright.beers20.commons

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class IOCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO
}

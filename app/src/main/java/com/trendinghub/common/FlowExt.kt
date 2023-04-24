package com.trendinghub.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

inline fun <T,U> Flow<T>.collectEmission(
    crossinline map: (value: T) -> U,
    scope: CoroutineScope,
    initialValue: U? = null,
    uiStateFlow: MutableStateFlow<U>
) {
    val flow = this
    scope.launch {
        // emit init state if not null
        initialValue?.let {
            uiStateFlow.emit(it)
        }
        // collect data stream
        flow.collect {
            uiStateFlow.emit(map.invoke(it))
        }
    }
}
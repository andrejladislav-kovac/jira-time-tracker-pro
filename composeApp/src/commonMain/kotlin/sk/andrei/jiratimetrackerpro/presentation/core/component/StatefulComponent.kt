package sk.andrei.jiratimetrackerpro.presentation.core.component

import com.arkivanov.decompose.value.Value

interface StatefulComponent <T : Any> {

    val state: Value<T>

}
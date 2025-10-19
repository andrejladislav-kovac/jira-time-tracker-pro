package sk.andrei.jiratimetrackerpro

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class RootComponentImpl(
    context: ComponentContext
): RootComponent, ComponentContext by context {

    override val state: Value<String> = MutableValue("OK")

}
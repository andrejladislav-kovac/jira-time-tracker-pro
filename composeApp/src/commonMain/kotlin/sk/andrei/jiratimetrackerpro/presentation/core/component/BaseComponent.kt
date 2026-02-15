package sk.andrei.jiratimetrackerpro.presentation.core.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer
import org.koin.core.component.KoinComponent

abstract class BaseComponent<STATE: Any>(
    context: ComponentContext,
    stateStoringName: String? = null,
    private val initialState: STATE,
    serializer: KSerializer<STATE>
) : KoinComponent, ComponentContext by context {

    private val mutableState: MutableValue<STATE> = MutableValue(
        initialValue = stateStoringName?.let { stateKeeper.consume(key = it, strategy = serializer) } ?: initialState
    )

    private val backgroundScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val foregroundScope = CoroutineScope(Dispatchers.Main)

    val state: Value<STATE> = mutableState

    init {
        stateStoringName?.let {
            stateKeeper.register(
                key = it,
                strategy = serializer,
            ) {
                state.value
            }
        }
    }

    protected fun updateState(provider: (STATE) -> STATE): STATE {
        val newState = provider(state.value)
        doInForeground {
            mutableState.value = newState
        }
        return newState
    }

    protected fun reset() = updateState { initialState }

    protected fun doInBackground(action: suspend () -> Unit) = backgroundScope.launch {
        action()
    }

    protected fun doInForeground(action: suspend () -> Unit) = foregroundScope.launch {
        action()
    }

    fun validateComponents(vararg components: ValidatableComponent<*>) = components.fold(true) { acc, component -> component.validate() && acc }
}
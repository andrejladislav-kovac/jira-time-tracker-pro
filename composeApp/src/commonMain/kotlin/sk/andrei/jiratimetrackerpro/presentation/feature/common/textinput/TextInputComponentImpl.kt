package sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput

import com.arkivanov.decompose.ComponentContext
import sk.andrei.jiratimetrackerpro.presentation.core.BaseComponent

open class TextInputComponentImpl(
    context: ComponentContext,
    stateStoringName: String? = null,
    private val validator: ((String) -> Boolean) = { true }
) : TextInputComponent, BaseComponent<TextInputComponent.State>(
    context = context,
    stateStoringName = stateStoringName,
    initialState = TextInputComponent.State(),
    serializer = TextInputComponent.State.serializer(),
) {

    override fun onChange(value: String, shouldValidate: Boolean) {
        state.update {
            it.copy(
                text = value,
                isValid = if (shouldValidate) validator(value) else it.isValid
            )
        }
    }
}
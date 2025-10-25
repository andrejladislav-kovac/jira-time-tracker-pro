package sk.andrei.jiratimetrackerpro.presentation.feature.common.passwordinput

import com.arkivanov.decompose.ComponentContext
import sk.andrei.jiratimetrackerpro.presentation.core.BaseComponent

open class PasswordInputComponentImpl(
    context: ComponentContext,
    stateStoringName: String? = null,
    private val validator: ((String) -> Boolean) = { true }
) : PasswordInputComponent, BaseComponent<PasswordInputComponent.State>(
    context = context,
    stateStoringName = stateStoringName,
    initialState = PasswordInputComponent.State(),
    serializer = PasswordInputComponent.State.serializer(),
) {



    override fun onChange(value: String, shouldValidate: Boolean) {
        state.update {
            it.copy(
                password = value,
                isValid = if (shouldValidate) validator(value) else it.isValid
            )
        }
    }

    override fun onVisibilityToggle() {
        state.update {
            it.copy(isHidden = !it.isHidden)
        }
    }
}
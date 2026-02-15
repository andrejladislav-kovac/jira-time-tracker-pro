package sk.andrei.jiratimetrackerpro.presentation.core.component.passwordinput

import com.arkivanov.decompose.ComponentContext
import sk.andrei.jiratimetrackerpro.presentation.core.component.BaseComponent

open class PasswordInputComponentImpl(
    context: ComponentContext,
    stateStoringName: String? = null,
    override val validator: ((String) -> Boolean) = { true }
) : PasswordInputComponent, BaseComponent<PasswordInputComponent.State>(
    context = context,
    stateStoringName = stateStoringName,
    initialState = PasswordInputComponent.State(),
    serializer = PasswordInputComponent.State.serializer(),
) {

    override fun onChange(value: String, shouldValidate: Boolean) {
        updateState {
            it.copy(
                password = value,
                isValid = if (shouldValidate) validator(value) else it.isValid
            )
        }
    }

    override fun onVisibilityToggle() {
        updateState {
            it.copy(isHidden = !it.isHidden)
        }
    }

    override fun validate(): Boolean {
        return updateState {
            it.copy(
                isValid = validator(it.password)
            )
        }.isValid
    }
}
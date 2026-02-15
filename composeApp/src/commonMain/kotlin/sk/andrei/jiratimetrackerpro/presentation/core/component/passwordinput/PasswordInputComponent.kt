package sk.andrei.jiratimetrackerpro.presentation.core.component.passwordinput

import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.component.StatefulComponent
import sk.andrei.jiratimetrackerpro.presentation.core.component.ValidatableComponent

interface PasswordInputComponent :
    StatefulComponent<PasswordInputComponent.State>,
    ValidatableComponent<String> {

    val value: String
        get() = state.value.password

    fun onChange(value: String, shouldValidate: Boolean = true)

    fun onVisibilityToggle()

    @Serializable
    data class State(
        val password: String = "",
        val isValid: Boolean = true,
        val isHidden: Boolean = true
    )

}
package sk.andrei.jiratimetrackerpro.presentation.feature.common.passwordinput

import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.StatefulComponent

interface PasswordInputComponent: StatefulComponent<PasswordInputComponent.State> {

    val value: String
        get() = state.value.password

    fun onChange(value: String, shouldValidate: Boolean = true)

    fun onVisibilityToggle()

    @Serializable
    data class State (
        val password: String = "",
        val isValid: Boolean = true,
        val isHidden: Boolean = true
    )

}
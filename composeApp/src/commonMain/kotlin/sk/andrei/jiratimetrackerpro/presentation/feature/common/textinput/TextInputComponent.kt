package sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput

import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.StatefulComponent

interface TextInputComponent: StatefulComponent<TextInputComponent.State> {

    val value: String
        get() = state.value.text

    fun onChange(value: String, shouldValidate: Boolean = true)

    @Serializable
    data class State (
        val text: String = "",
        val isValid: Boolean = true
    )

}
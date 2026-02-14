package sk.andrei.jiratimetrackerpro.presentation.core.component

interface ValidatableComponent<T> {

    val validator: (T) -> Boolean

    /**
     * Validates a value of state.
     * @return true if the value is valid, false otherwise
     */
    fun validate(): Boolean
}

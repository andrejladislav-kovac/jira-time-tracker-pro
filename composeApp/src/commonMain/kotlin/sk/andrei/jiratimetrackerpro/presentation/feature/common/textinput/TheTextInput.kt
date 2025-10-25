package sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun TheTextInput(
    component: TextInputComponent,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
) {
    val state = component.state.subscribeAsState().value
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        label = label?.let {
            { Text(text = it) }
        },
        placeholder = placeholder?.let {
            { Text(text = it) }
        },
        value = state.text,
        onValueChange = component::onChange,
        isError = !state.isValid,
        singleLine = true,
    )
}
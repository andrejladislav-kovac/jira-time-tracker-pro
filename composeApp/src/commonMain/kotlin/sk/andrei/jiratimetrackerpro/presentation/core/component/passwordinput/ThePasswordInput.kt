package sk.andrei.jiratimetrackerpro.presentation.core.component.passwordinput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun ThePasswordInput(
    component: PasswordInputComponent,
    modifier: Modifier = Modifier,
    label: String? = null,
) {
    val state = component.state.subscribeAsState().value

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = state.password,
        onValueChange = component::onChange,
        label = label?.let {
            { Text(text = it) }
        },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        isError = !state.isValid
    )

}
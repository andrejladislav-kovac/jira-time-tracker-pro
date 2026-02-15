package sk.andrei.jiratimetrackerpro.presentation.core

import androidx.compose.runtime.Composable
import sk.andrei.jiratimetrackerpro.presentation.core.type.Content

@Composable
fun Boolean.ifYes(content: Content): Boolean {
    if (this) content()
    return this
}


@Composable
fun Boolean.ifNot(content: Content): Boolean {
    if (!this) content()
    return this
}
package sk.andrei.jiratimetrackerpro.presentation.core.ui

import androidx.compose.runtime.Composable

@Composable
fun ScreenOrientationLayout(
    portraitContent: @Composable () -> Unit,
    landscapeContent: @Composable () -> Unit,
) {
    if (isLandscape()) {
        landscapeContent()
    } else {
        portraitContent()
    }
}


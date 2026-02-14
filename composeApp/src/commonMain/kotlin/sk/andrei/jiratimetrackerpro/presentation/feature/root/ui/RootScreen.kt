package sk.andrei.jiratimetrackerpro.presentation.feature.root.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui.DashboardScreen
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.settings.ui.SettingsScreen

@Composable
fun RootScreen(
    component: RootComponent,
    modifier: Modifier,
    innerPadding: PaddingValues? = null
) {
    Surface(
        modifier = innerPadding?.let { modifier.padding(innerPadding) } ?: modifier,
        color = Color.White
    ) {
        Children(
            stack = component.stack,
            modifier = modifier,
            animation = stackAnimation(fade()),
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.SettingsChild -> SettingsScreen(component = child.component)
                is RootComponent.Child.DashboardChild -> DashboardScreen(component = child.component)
            }
        }
    }
}
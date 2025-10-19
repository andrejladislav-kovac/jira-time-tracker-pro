package sk.andrei.jiratimetrackerpro

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun main() {
    val lifecycle = LifecycleRegistry()

    val rootComponent = runOnUiThread {
        RootComponentImpl(DefaultComponentContext(lifecycle = lifecycle))
    }

    application {
        val windowState = rememberWindowState()

        LifecycleController(lifecycle, windowState)

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "My Application"
        ) {
            MaterialTheme {
                Surface {
                    App(rootComponent)
                }
            }
        }
    }
}
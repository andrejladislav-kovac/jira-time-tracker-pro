package sk.andrei.jiratimetrackerpro

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.context.startKoin
import sk.andrei.jiratimetrackerpro.data.dataModule
import sk.andrei.jiratimetrackerpro.domain.domainModule
import sk.andrei.jiratimetrackerpro.infrastructure.infrastructureModule
import sk.andrei.jiratimetrackerpro.infrastructure.platformInfrastructureModule
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.feature.root.ui.RootScreen

/**
 * JVM's starting point
 */
fun main() {
    startKoin {
        modules(
            dataModule,
            infrastructureModule,
            platformInfrastructureModule,
            domainModule
        )
    }

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
                RootScreen(
                    modifier = Modifier,
                    component = rootComponent,
                )
            }
        }
    }
}
package sk.andrei.jiratimetrackerpro

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController
import sk.andrei.jiratimetrackerpro.data.dataModule
import sk.andrei.jiratimetrackerpro.domain.domainModule
import sk.andrei.jiratimetrackerpro.infrastructure.infrastructureModule
import sk.andrei.jiratimetrackerpro.infrastructure.platformInfrastructureModule
import sk.andrei.jiratimetrackerpro.presentation.feature.root.component.RootComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.feature.root.ui.RootScreen

fun MainViewController(): UIViewController {

    startKoin {
        modules(
            dataModule,
            infrastructureModule,
            platformInfrastructureModule,
            domainModule
        )
    }

    val lifecycle = LifecycleRegistry()

    val rootComponent = RootComponentImpl(
        context = DefaultComponentContext(lifecycle = lifecycle)
    )

    return ComposeUIViewController {
        RootScreen(
            modifier = Modifier.padding(top = 32.dp), // FIXME
            component = rootComponent,
        )
    }
}
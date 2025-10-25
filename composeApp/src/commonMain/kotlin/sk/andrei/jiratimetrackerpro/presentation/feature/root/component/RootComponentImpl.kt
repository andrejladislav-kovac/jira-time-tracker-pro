package sk.andrei.jiratimetrackerpro.presentation.feature.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component.DashboardComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.settings.component.SettingsComponentImpl

class RootComponentImpl(
    context: ComponentContext
): RootComponent, ComponentContext by context {

    private val navigation = StackNavigation<Config>()

    override val state: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Dashboard,
        handleBackButton = true,
        childFactory = ::childFactory
    )

    private fun childFactory(config: Config, context: ComponentContext): RootComponent.Child = when (config) {
        is Config.Dashboard -> createDashboard(context)
        is Config.Settings -> createSettings(context)
    }

    private fun createSettings(context: ComponentContext) =
        RootComponent.Child.SettingsChild(SettingsComponentImpl(context))

    private fun createDashboard(context: ComponentContext) =
        RootComponent.Child.DashboardChild(object : DashboardComponent{})

    @Serializable
    sealed interface Config {
        @Serializable
        data object Dashboard : Config

        @Serializable
        data object Settings : Config
    }

}
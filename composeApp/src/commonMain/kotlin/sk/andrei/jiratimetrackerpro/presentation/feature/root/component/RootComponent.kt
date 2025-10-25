package sk.andrei.jiratimetrackerpro.presentation.feature.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import sk.andrei.jiratimetrackerpro.presentation.core.StatefulComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component.DashboardComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.settings.component.SettingsComponent

interface RootComponent: StatefulComponent<ChildStack<*, RootComponent.Child>> {

    val stack: Value<ChildStack<*, Child>>
        get() = state

    sealed class Child {
        class DashboardChild(val component: DashboardComponent): Child()
        class SettingsChild(val component: SettingsComponent): Child()
    }

}
package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component

import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.component.StatefulComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui.IssueListItemVo

interface DashboardComponent: StatefulComponent<DashboardComponent.State> {

    fun onMenuClick()

    fun refresh()

    @Serializable
    data class State(
        val issues: List<IssueListItemVo> = emptyList()
    )

}
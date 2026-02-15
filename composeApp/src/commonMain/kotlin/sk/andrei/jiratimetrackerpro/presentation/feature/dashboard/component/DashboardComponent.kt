package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component

import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.component.StatefulComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui.IssueListItemVo

interface DashboardComponent: StatefulComponent<DashboardComponent.State> {

    fun onMenuClick()

    fun onItemLongClick(item: IssueListItemVo)

    fun refresh()

    @Serializable
    data class State(
        val displayName: String? = null,
        val issues: List<IssueListItemVo> = emptyList(),
        val isLoading: Boolean = true
    )

}
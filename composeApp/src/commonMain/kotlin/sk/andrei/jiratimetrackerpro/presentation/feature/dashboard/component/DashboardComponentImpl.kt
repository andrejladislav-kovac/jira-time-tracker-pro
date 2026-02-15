package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import org.koin.core.component.inject
import sk.andrei.jiratimetrackerpro.domain.feature.issue.usecase.GetIssuesUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase.GetJiraProfileUseCase
import sk.andrei.jiratimetrackerpro.presentation.core.component.BaseComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.common.mapper.toManDaysHoursMinutes
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.mapper.toVo
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui.IssueListItemVo
import kotlin.getValue

class DashboardComponentImpl(
    context: ComponentContext,
    private val openSettings: () -> Unit,
) : DashboardComponent, BaseComponent<DashboardComponent.State>(
    context = context,
    stateStoringName = "dashboard",
    serializer = DashboardComponent.State.serializer(),
    initialState = DashboardComponent.State()
) {

    private val getIssues: GetIssuesUseCase by inject()

    private val getJiraProfile: GetJiraProfileUseCase by inject()

    init {
        lifecycle.doOnCreate {
            updateState { it.copy(isLoading = true) }
            doInBackground {
                loadProfile()
                loadIssues()
            }
        }
    }

    override fun onMenuClick() = openSettings()

    override fun onItemLongClick(item: IssueListItemVo) {
        updateState { state ->
            state.copy(issues = state.issues.map { it.copy(isExpanded = it.key == item.key) })
        }
    }

    override fun refresh() {
        doInBackground(::loadIssues)
    }

    private suspend fun loadProfile() {
        val profile = getJiraProfile().getOrNull()
        updateState { it.copy(displayName = profile?.displayName) }
    }

    private suspend fun loadIssues() {
        getIssues(GetIssuesUseCase.Params()).onSuccess { issues ->
            val issues = issues.map { it ->
                IssueListItemVo(
                    key = it.key,
                    title = it.title,
                    status = it.status,
                    isExpanded = false,
                    spentTime = it.spendTime?.toManDaysHoursMinutes() ?: "No time",
                    priority = it.priority.toVo()
                )
            }
            updateState { it.copy(issues = issues, isLoading = false) }
        }
    }


}
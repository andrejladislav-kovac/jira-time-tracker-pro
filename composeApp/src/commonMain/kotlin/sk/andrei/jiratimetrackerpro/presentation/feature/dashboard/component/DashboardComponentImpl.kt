package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component

import androidx.compose.runtime.key
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import org.koin.core.component.inject
import sk.andrei.jiratimetrackerpro.domain.feature.issue.usecase.GetIssuesUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.GetJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.presentation.core.component.BaseComponent
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

    init {
        lifecycle.doOnCreate {
            doInBackground {
                getIssues(GetIssuesUseCase.Params()).onSuccess { issues ->
                    val issues = issues.map {
                        IssueListItemVo(
                            key = it.key,
                            title = it.title,
                            status = it.status.name
                        )
                    }
                    state.update { it.copy(issues = issues) }
                }
            }
        }
    }

    override fun onMenuClick() = openSettings()

    override fun refresh() {

    }

}
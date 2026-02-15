package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import sk.andrei.jiratimetrackerpro.presentation.core.ifNot
import sk.andrei.jiratimetrackerpro.presentation.core.ifYes
import sk.andrei.jiratimetrackerpro.presentation.core.ui.LoadingBox
import sk.andrei.jiratimetrackerpro.presentation.core.ui.theme.Dimens
import sk.andrei.jiratimetrackerpro.presentation.core.ui.screen.PrimaryAction
import sk.andrei.jiratimetrackerpro.presentation.core.ui.screen.Screen
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component.DashboardComponent

@Composable
fun DashboardScreen(
    component: DashboardComponent
) {
    val model = component.state.subscribeAsState().value

    Screen(
        primaryAction = PrimaryAction.Menu(component::onMenuClick),
        title = model.displayName ?: "Log in"
    ) {
        model.isLoading.ifYes {
            LoadingBox()
        }.ifNot {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = Dimens.Small),
                verticalArrangement = Arrangement.spacedBy(space = Dimens.Small)
            ) {
                model.issues.firstOrNull()?.let { first ->
                    stickyHeader {
                        IssueListItem(
                            model = first,
                            onLongClick = {
                                component.onItemLongClick(first)
                            }
                        )
                    }
                }
                items(model.issues.drop(1)) {
                    IssueListItem(
                        model = it,
                        onLongClick = {
                            component.onItemLongClick(it)
                        }
                    )
                }
            }
        }

    }
}




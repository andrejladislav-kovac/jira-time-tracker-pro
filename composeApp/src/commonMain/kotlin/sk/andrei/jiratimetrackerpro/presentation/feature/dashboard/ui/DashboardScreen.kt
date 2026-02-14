package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import sk.andrei.jiratimetrackerpro.presentation.core.ui.CardListItem
import sk.andrei.jiratimetrackerpro.presentation.feature.common.screen.PrimaryAction
import sk.andrei.jiratimetrackerpro.presentation.feature.common.screen.Screen
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.component.DashboardComponent

@Composable
fun DashboardScreen(
    component: DashboardComponent
) {
    val model = component.state.subscribeAsState().value

    Screen(
        primaryAction = PrimaryAction.Menu(component::onMenuClick)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            item {
                CardListItem(
                    modifier = Modifier.fillParentMaxHeight(0.5f)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 64.sp),
                            text = "7:53",
                        )
                    }
                }
            }
            if (model.issues.isNotEmpty()) {
                stickyHeader {
                    IssueListItem(
                        model = model.issues.first()
                    )
                }
            }
            items(model.issues.drop(1)) {
                IssueListItem(model = it)
            }
        }
    }
}




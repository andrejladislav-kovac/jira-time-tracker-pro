package sk.andrei.jiratimetrackerpro.presentation.feature.settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import sk.andrei.jiratimetrackerpro.presentation.feature.common.passwordinput.ThePasswordInput
import sk.andrei.jiratimetrackerpro.presentation.feature.common.screen.Back
import sk.andrei.jiratimetrackerpro.presentation.feature.common.screen.Screen
import sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput.TheTextInput
import sk.andrei.jiratimetrackerpro.presentation.feature.settings.component.SettingsComponent

@Composable
fun SettingsScreen(
    component: SettingsComponent,
) {
    Screen(
        backAction = Back.Arrow(component::onBackClick),
        onSaveClick = component::onSaveClick
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            item {
                Text(
                    text = "JIRA setup",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            item {
                BaseItem {
                    TheTextInput(
                        component = component.urlComponent,
                        label = "url"
                    )
                }
            }
            item {
                BaseItem {
                    ThePasswordInput(
                        component = component.tokenComponent,
                        label = "token"
                    )
                }
            }
        }
    }
}

@Composable
private fun BaseItem(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(size = 8.dp),
                color = Color.White
            ),
        content = content
    )
}
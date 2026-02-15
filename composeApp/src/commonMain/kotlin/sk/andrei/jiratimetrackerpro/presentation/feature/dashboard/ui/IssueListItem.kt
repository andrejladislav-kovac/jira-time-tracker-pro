package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue
import sk.andrei.jiratimetrackerpro.presentation.core.ui.CardListItem
import sk.andrei.jiratimetrackerpro.presentation.core.ui.theme.Dimens

@Serializable
data class IssueListItemVo(
    val key: String,
    val title: String,
    val status: Issue.Status,
    val isExpanded: Boolean,
    val spentTime: String,
    val priority: IssuePriorityVo
)

@Composable
fun IssueListItem(
    model: IssueListItemVo,
    onLongClick: () -> Unit
) {
    CardListItem(
        onLongClick = onLongClick
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp).animateContentSize(),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(space = Dimens.Tiny)
                ) {
                    PriorityIcon(model.priority)
                    Text(
                        text = model.key,
                        fontWeight = FontWeight.Black
                    )
                }

                Text(
                    text = model.status.name,
                    fontWeight = FontWeight.Black,
                    color = when(model.status) {
                        Issue.Status.TODO -> Color(0xFF1E88E5)
                        Issue.Status.IN_PROGRESS -> Color(0xFF43A047)
                        Issue.Status.CODE_REVIEW -> Color(0xFFFB8C00)
                        else -> Color.Unspecified
                    }
                )
            }
            Text(
                text = model.title,
                maxLines = when(model.isExpanded) {
                    true -> Int.MAX_VALUE
                    false -> 2
                },
                overflow = TextOverflow.Ellipsis
            )
            if (model.isExpanded) {
                Text(
                    text = model.spentTime,
                    fontWeight = FontWeight.Black
                )
            }
        }
    }
}
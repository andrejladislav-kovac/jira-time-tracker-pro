package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import sk.andrei.jiratimetrackerpro.presentation.core.ui.CardListItem

@Serializable
data class IssueListItemVo(
    val key: String,
    val title: String,
    val status: String
)

@Composable
fun IssueListItem(
    model: IssueListItemVo,
) {
    CardListItem {
        Column(
            modifier = Modifier.padding(all = 8.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = model.key,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = model.status,
                    fontWeight = FontWeight.Black
                )
            }

            Text(
                text = model.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
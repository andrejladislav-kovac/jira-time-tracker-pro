package sk.andrei.jiratimetrackerpro.presentation.core.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jiratimetrackerpro.composeapp.generated.resources.Res
import jiratimetrackerpro.composeapp.generated.resources.ic_arrow_back
import jiratimetrackerpro.composeapp.generated.resources.ic_more
import jiratimetrackerpro.composeapp.generated.resources.ic_save
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import sk.andrei.jiratimetrackerpro.presentation.core.type.OnClick
import sk.andrei.jiratimetrackerpro.presentation.core.ui.theme.Dimens

@Composable
fun Screen(
    backAction: BackAction? = null,
    primaryAction: PrimaryAction? = null,
    title: String? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier.padding(
                    start = when {
                        backAction != null -> 4.dp
                        title != null -> Dimens.Small
                        else -> 0.dp
                    }
                ),
                horizontalArrangement = Arrangement.spacedBy(space = Dimens.Item),
            ) {
                backAction?.let { back ->
                    IconButton(
                        onClick = back.onClick
                    ) {
                        Icon(
                            painter = painterResource(back.icon),
                            contentDescription = null
                        )
                    }
                }
                title?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp
                    )
                }
            }

            primaryAction?.let { primaryAction ->
                Row(
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    IconButton(
                        onClick = primaryAction.onClick
                    ) {
                        Icon(
                            painter = painterResource(primaryAction.icon),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        content()
    }
}

sealed class BackAction(
    icon: DrawableResource,
    onClick: OnClick
) : ActionIcon(icon, onClick) {

    class Arrow(onBackClick: OnClick) : BackAction(
        Res.drawable.ic_arrow_back,
        onBackClick
    )

    class Cross(onBackClick: OnClick) : BackAction(
        TODO(),
        onBackClick
    )
}

sealed class PrimaryAction(
    icon: DrawableResource,
    onClick: OnClick
) : ActionIcon(icon, onClick) {

    class Save(onClick: OnClick) : PrimaryAction(
        Res.drawable.ic_save,
        onClick
    )

    class Menu(onBackClick: OnClick) : PrimaryAction(
        Res.drawable.ic_more,
        onBackClick
    )
}

abstract class ActionIcon(
    val icon: DrawableResource,
    val onClick: OnClick
)
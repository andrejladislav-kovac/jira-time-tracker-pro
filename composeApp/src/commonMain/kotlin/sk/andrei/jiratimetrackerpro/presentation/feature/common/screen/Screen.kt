package sk.andrei.jiratimetrackerpro.presentation.feature.common.screen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jiratimetrackerpro.composeapp.generated.resources.Res
import jiratimetrackerpro.composeapp.generated.resources.ic_arrow_back
import jiratimetrackerpro.composeapp.generated.resources.ic_more
import jiratimetrackerpro.composeapp.generated.resources.ic_save
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import sk.andrei.jiratimetrackerpro.presentation.core.type.OnClick

@Composable
fun Screen(
    backAction: BackAction? = null,
    primaryAction: PrimaryAction? = null,
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
                .padding(all = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row {
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
            }
            Row {
                primaryAction?.let { primaryAction ->
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
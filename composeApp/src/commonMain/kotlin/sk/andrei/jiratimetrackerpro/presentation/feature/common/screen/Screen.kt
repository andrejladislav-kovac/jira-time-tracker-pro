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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jiratimetrackerpro.composeapp.generated.resources.Res
import jiratimetrackerpro.composeapp.generated.resources.ic_arrow_back
import jiratimetrackerpro.composeapp.generated.resources.ic_save
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun Screen(
    backAction: Back? = null,
    onSaveClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.1f))
                .padding(all = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            backAction?.let { back ->
                IconButton(
                    onClick = back.onBackClick
                ) {
                    Icon(
                        painter = painterResource(back.icon),
                        contentDescription = null
                    )
                }
            }

            onSaveClick?.let {
                IconButton(
                    onClick = it
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_save),
                        contentDescription = null
                    )
                }
            }
        }
        content()
    }
}

sealed class Back(val onBackClick: () -> Unit) {

    abstract val icon: DrawableResource

    class Arrow(onBackClick: () -> Unit) : Back(onBackClick) {

        override val icon = Res.drawable.ic_arrow_back
    }
    class Cross(onBackClick: () -> Unit) : Back(onBackClick) {
        override val icon = TODO("Add icon")
    }


}
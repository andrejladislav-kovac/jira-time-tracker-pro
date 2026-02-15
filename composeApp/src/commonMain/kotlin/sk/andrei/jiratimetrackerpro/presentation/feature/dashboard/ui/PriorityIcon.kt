package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import jiratimetrackerpro.composeapp.generated.resources.Res
import jiratimetrackerpro.composeapp.generated.resources.ic_arrow_up
import jiratimetrackerpro.composeapp.generated.resources.ic_block
import jiratimetrackerpro.composeapp.generated.resources.ic_drop_down
import jiratimetrackerpro.composeapp.generated.resources.ic_up_down
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

enum class IssuePriorityVo(
    val icon: DrawableResource,
    val rotation: Float,
    val color: Color
) {
    LOWEST(Res.drawable.ic_arrow_up, 180f, Color(0xFF1E88E5)),
    LOW(Res.drawable.ic_drop_down, 0f, Color(0xFF1E88E5)),
    MEDIUM(Res.drawable.ic_up_down, 0f, Color(0xFFFB8C00)),
    HIGH(Res.drawable.ic_drop_down, 180f, Color(0xFFFB8C00)),
    HIGHER(Res.drawable.ic_arrow_up, 0f, Color(0xFFFB8C00)),
    HIGHEST(Res.drawable.ic_block, 0f, Color(0xFFE53935))
}

@Composable
fun PriorityIcon(model: IssuePriorityVo) {
    Icon(
        modifier = Modifier.rotate(model.rotation),
        painter = painterResource(model.icon),
        tint = model.color,
        contentDescription = null
    )
}
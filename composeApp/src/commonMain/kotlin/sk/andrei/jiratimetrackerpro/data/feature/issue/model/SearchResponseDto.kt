package sk.andrei.jiratimetrackerpro.data.feature.issue.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDto(
    @SerialName("issues")
    val issues: List<IssueDto>
)



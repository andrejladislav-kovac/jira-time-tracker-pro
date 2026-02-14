package sk.andrei.jiratimetrackerpro.data.feature.profile.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JiraProfileDto(
    @SerialName("displayName")
    val displayName: String
)

package sk.andrei.jiratimetrackerpro.data.feature.issue.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IssueDto(
    val expand: String,
    val id: String,
    val key: String,
    val fields: Fields
) {

    @Serializable
    data class Fields(
        val summary: String,
        val status: Status,
        @SerialName("timespent")
        val spentTime: Long?,
        val priority: Priority
    )

    @Serializable
    data class Priority(
        val name: PriorityName
    )

    @Serializable
    enum class PriorityName {
        @SerialName("Lowest")
        LOWEST,
        @SerialName("Low")
        LOW,
        @SerialName("Medium")
        MEDIUM,
        @SerialName("High")
        HIGH,
        @SerialName("Higher")
        HIGHER,
        @SerialName("Highest")
        HIGHEST
    }

    @Serializable
    data class Status(
        val name: StatusName? = null
    )

    @Serializable
    enum class StatusName {
        @SerialName("To Do")
        TODO,
        @SerialName("In Progress")
        IN_PROGRESS,
        @SerialName("Code Review")
        CODE_REVIEW,
        @SerialName("Done")
        DONE
    }

}

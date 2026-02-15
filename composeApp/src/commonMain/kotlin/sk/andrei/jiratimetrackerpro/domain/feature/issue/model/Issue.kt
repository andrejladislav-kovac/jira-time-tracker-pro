package sk.andrei.jiratimetrackerpro.domain.feature.issue.model

import sk.andrei.jiratimetrackerpro.domain.core.Model

data class Issue(
    override val id: String,
    val key: String,
    val title: String,
    val status: Status,
    val spendTime: Long?,
    val priority: Priority
): Model<String> {


    enum class Status {
        TODO,
        IN_PROGRESS,
        CODE_REVIEW,
        DONE,
        UNKNOWN
    }

    enum class Priority {
        LOWEST,
        LOW,
        MEDIUM,
        HIGH,
        HIGHER,
        HIGHEST
    }



}


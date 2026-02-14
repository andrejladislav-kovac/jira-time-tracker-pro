package sk.andrei.jiratimetrackerpro.domain.feature.issue.model

import sk.andrei.jiratimetrackerpro.domain.core.Model

data class Issue(
    override val id: String,
    val key: String,
    val title: String,
    val status: Status,
): Model<String> {


    enum class Status {
        TODO,
        IN_PROGRESS,
        CODE_REVIEW,
        DONE,
        UNKNOWN
    }



}


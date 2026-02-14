package sk.andrei.jiratimetrackerpro.domain.feature.user.model

data class User(
    val organization: String,
    val email: String,
    val token: String
)

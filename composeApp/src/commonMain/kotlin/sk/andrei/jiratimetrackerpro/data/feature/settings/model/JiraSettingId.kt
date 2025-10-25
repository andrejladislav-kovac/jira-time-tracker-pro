package sk.andrei.jiratimetrackerpro.data.feature.settings.model

enum class JiraSettingId(override val id: String): SettingId {
    URL("jira_url"),
    TOKEN("jira_token")
}
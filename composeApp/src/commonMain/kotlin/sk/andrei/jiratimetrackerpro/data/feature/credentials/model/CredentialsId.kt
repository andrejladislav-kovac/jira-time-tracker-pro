package sk.andrei.jiratimetrackerpro.data.feature.credentials.model

import sk.andrei.jiratimetrackerpro.data.feature.common.settings.model.GenericValueId

enum class CredentialsId(override val id: String): GenericValueId {
    ORGANIZATION("jira_organization"),
    EMAIL("jira_email"),
    TOKEN("jira_token")
}
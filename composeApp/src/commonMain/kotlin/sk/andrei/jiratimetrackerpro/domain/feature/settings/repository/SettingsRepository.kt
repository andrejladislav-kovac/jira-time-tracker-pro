package sk.andrei.jiratimetrackerpro.domain.feature.settings.repository

import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings


interface SettingsRepository {

    suspend fun saveJiraSettings(jiraSettings: JiraSettings)
    suspend fun getJiraSettings(): JiraSettings

}
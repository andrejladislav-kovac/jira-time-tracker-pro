package sk.andrei.jiratimetrackerpro.domain.feature.settings.repository

import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings


interface SettingsRepository {

    fun saveJiraSettings(jiraSettings: JiraSettings)
    fun getJiraSettings(): JiraSettings

}
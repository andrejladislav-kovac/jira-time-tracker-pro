package sk.andrei.jiratimetrackerpro.data.feature.settings.repository

import app.cash.sqldelight.async.coroutines.awaitAsList
import sk.andrei.jiratimetrackerpro.data.database.SettingEntity
import sk.andrei.jiratimetrackerpro.data.database.SettingEntityQueries
import sk.andrei.jiratimetrackerpro.data.feature.settings.mapper.toEntity
import sk.andrei.jiratimetrackerpro.data.feature.settings.mapper.toJiraSettings
import sk.andrei.jiratimetrackerpro.data.feature.settings.model.JiraSettingId
import sk.andrei.jiratimetrackerpro.data.feature.settings.model.SettingId
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.SettingsRepository

class SettingsRepositoryImpl(
    private val settingsEntityQueries: SettingEntityQueries
): SettingsRepository {

    override suspend fun saveJiraSettings(jiraSettings: JiraSettings) = jiraSettings.toEntity().saveSettings()

    override suspend fun getJiraSettings() = getSettings<JiraSettingId>().toJiraSettings()

    private suspend fun List<SettingEntity>.saveSettings() = forEach {
        settingsEntityQueries.upsert(it.id, it.value_)
    }
    private suspend inline fun <reified T> getSettings(): List<SettingEntity> where T : Enum<T>, T : SettingId {
        val ids = enumValues<T>().map { it.id }
        return settingsEntityQueries.findByIds(ids).awaitAsList()
    }
}
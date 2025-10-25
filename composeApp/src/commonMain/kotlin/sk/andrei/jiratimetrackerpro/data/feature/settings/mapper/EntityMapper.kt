package sk.andrei.jiratimetrackerpro.data.feature.settings.mapper

import sk.andrei.jiratimetrackerpro.data.database.SettingEntity
import sk.andrei.jiratimetrackerpro.data.feature.settings.model.JiraSettingId
import sk.andrei.jiratimetrackerpro.data.feature.settings.model.SettingId
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings

fun JiraSettings.toEntity() = listOf(
    JiraSettingId.URL.toEntity(url),
    JiraSettingId.TOKEN.toEntity(token)
)

fun List<SettingEntity>.toJiraSettings() = JiraSettings(
    url = findValue(JiraSettingId.URL),
    token = findValue(JiraSettingId.TOKEN)
)

private fun SettingId.toEntity(value: String?) = SettingEntity(id, value)
private fun List<SettingEntity>.findValue(settingId: SettingId) = find { it.id == settingId.id }?.value_
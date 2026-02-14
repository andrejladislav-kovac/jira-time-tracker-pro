package sk.andrei.jiratimetrackerpro.data.feature.credentials.mapper

import sk.andrei.jiratimetrackerpro.data.database.SettingEntity
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.mapper.findValue
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.mapper.toEntity
import sk.andrei.jiratimetrackerpro.data.feature.credentials.model.CredentialsId
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.Credentials

fun Credentials.toEntity() = listOf(
    CredentialsId.ORGANIZATION.toEntity(organization),
    CredentialsId.EMAIL.toEntity(email),
    CredentialsId.TOKEN.toEntity(token)
)

fun List<SettingEntity>.toJiraSettings() = Credentials(
    organization = findValue(CredentialsId.ORGANIZATION),
    email = findValue(CredentialsId.EMAIL),
    token = findValue(CredentialsId.TOKEN)
)


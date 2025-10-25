package sk.andrei.jiratimetrackerpro.data

import app.cash.sqldelight.db.SqlDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase
import sk.andrei.jiratimetrackerpro.data.database.SettingEntityQueries
import sk.andrei.jiratimetrackerpro.data.feature.issue.repository.LocalIssueRepositoryImpl
import sk.andrei.jiratimetrackerpro.data.feature.issue.repository.RemoteIssueRepositoryImpl
import sk.andrei.jiratimetrackerpro.data.feature.settings.repository.SettingsRepositoryImpl
import sk.andrei.jiratimetrackerpro.domain.feature.issue.repository.LocalIssueRepository
import sk.andrei.jiratimetrackerpro.domain.feature.issue.repository.RemoteIssueRepository
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.SettingsRepository

val dataModule = module {

    single<JttpDatabase> {
        JttpDatabase(
            driver = get<SqlDriver>()
        )
    }

    single<LocalIssueRepository> {
        LocalIssueRepositoryImpl()
    }

    single<RemoteIssueRepository> {
        RemoteIssueRepositoryImpl(
            httpClient = get()
        )
    }

    single<SettingsRepository> {
        SettingsRepositoryImpl(
            settingsEntityQueries = get<JttpDatabase>().settingEntityQueries
        )
    }

}
package sk.andrei.jiratimetrackerpro.data

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.core.network.NetworkConfigRepositoryImpl
import sk.andrei.jiratimetrackerpro.data.core.network.NetworkClient
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase
import sk.andrei.jiratimetrackerpro.data.feature.issue.repository.IssueRepositoryImpl
import sk.andrei.jiratimetrackerpro.data.feature.profile.repository.JiraProfileRepositoryImpl
import sk.andrei.jiratimetrackerpro.data.feature.credentials.repository.CredentialsRepositoryImpl
import sk.andrei.jiratimetrackerpro.domain.feature.issue.repository.IssueRepository
import sk.andrei.jiratimetrackerpro.domain.feature.profile.repository.JiraProfileRepository
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.CredentialsRepository
import sk.andrei.jiratimetrackerpro.data.core.network.NetworkConfigRepository
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.repository.GenericValueRepository
import sk.andrei.jiratimetrackerpro.data.feature.user.repository.UserRepositoryImpl
import sk.andrei.jiratimetrackerpro.domain.feature.user.repository.UserRepository

val dataModules = platformDataModule + module {

    single<JttpDatabase> {
        JttpDatabase(
            driver = get<SqlDriver>()
        )
    }

    single<IssueRepository> {
        IssueRepositoryImpl(
            networkClient = get()
        )
    }

    single<GenericValueRepository> {
        GenericValueRepository(
            settingsEntityQueries = get<JttpDatabase>().settingEntityQueries
        )
    }

    single<CredentialsRepository> {
        CredentialsRepositoryImpl(
            genericValueRepository = get()
        )
    }

    single<UserRepository> {
        UserRepositoryImpl(
            credentialsRepository = get(),
            networkClient = get()
        )
    }

    single<NetworkConfigRepository> {
        NetworkConfigRepositoryImpl(
            credentialsRepository = get()
        )
    }

    single<JiraProfileRepository> {
        JiraProfileRepositoryImpl(
            networkClient = get(),
            genericValueRepository = get()
        )
    }

    single<NetworkClient> {
        NetworkClient(
            networkConfigRepository = get()
        )
    }

}

expect val platformDataModule: Module
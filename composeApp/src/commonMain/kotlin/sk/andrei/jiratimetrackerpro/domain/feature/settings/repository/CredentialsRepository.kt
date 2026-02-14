package sk.andrei.jiratimetrackerpro.domain.feature.settings.repository

import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.Credentials


interface CredentialsRepository {

    suspend fun saveCredentials(credentials: Credentials)
    suspend fun getCredentials(): Credentials

}
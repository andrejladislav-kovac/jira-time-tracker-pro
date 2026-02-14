package sk.andrei.jiratimetrackerpro.data.feature.credentials.repository

import sk.andrei.jiratimetrackerpro.data.feature.credentials.mapper.toEntity
import sk.andrei.jiratimetrackerpro.data.feature.credentials.mapper.toJiraSettings
import sk.andrei.jiratimetrackerpro.data.feature.credentials.model.CredentialsId
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.repository.GenericValueRepository
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.Credentials
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.CredentialsRepository

class CredentialsRepositoryImpl(
    private val genericValueRepository: GenericValueRepository
) : CredentialsRepository {

    override suspend fun saveCredentials(credentials: Credentials) =
        genericValueRepository.save(credentials.toEntity())

    override suspend fun getCredentials() =
        genericValueRepository.load<CredentialsId>().toJiraSettings()

}
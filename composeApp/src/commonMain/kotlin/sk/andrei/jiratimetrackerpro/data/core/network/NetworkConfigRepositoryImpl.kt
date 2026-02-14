package sk.andrei.jiratimetrackerpro.data.core.network

import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.Credentials
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.CredentialsRepository

class NetworkConfigRepositoryImpl(
    private val credentialsRepository: CredentialsRepository
): NetworkConfigRepository {

    override suspend fun get(): NetworkConfig {
        return credentialsRepository.getCredentials().toDefaultNetworkConfig()
    }

    private fun Credentials.toDefaultNetworkConfig() = NetworkConfig(
        organization = organization ?: "",
        username = email ?: "",
        password = token ?: ""
    )

}
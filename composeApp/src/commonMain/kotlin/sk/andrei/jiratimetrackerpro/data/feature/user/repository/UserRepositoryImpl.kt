package sk.andrei.jiratimetrackerpro.data.feature.user.repository

import sk.andrei.jiratimetrackerpro.data.core.network.NetworkClient
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.Credentials
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.CredentialsRepository
import sk.andrei.jiratimetrackerpro.domain.feature.user.model.User
import sk.andrei.jiratimetrackerpro.domain.feature.user.repository.UserRepository

class UserRepositoryImpl(
    private val credentialsRepository: CredentialsRepository,
    private val networkClient: NetworkClient
) : UserRepository {

    override suspend fun save(entity: User): Result<User> {
        credentialsRepository.saveCredentials(
            Credentials(
                organization = entity.organization,
                email = entity.email,
                token = entity.token
            )
        )
        networkClient.invalidate()
        return Result.success(entity)
    }

    override suspend fun findById(id: Unit): Result<User> {
        val jiraSettings = credentialsRepository.getCredentials()
        if (jiraSettings.organization == null || jiraSettings.email == null || jiraSettings.token == null) {
            return Result.failure(RuntimeException("Not found"))
        }
        return Result.success(User(
            organization = jiraSettings.organization,
            email = jiraSettings.email,
            token = jiraSettings.token
        ))
    }

    override suspend fun findAll(fresh: Boolean): Result<List<User>> = findById(Unit).fold(
        onSuccess = { Result.success(listOf(it)) },
        onFailure = { Result.failure(it) }
    )


}
package sk.andrei.jiratimetrackerpro.data.feature.profile.repository

import sk.andrei.jiratimetrackerpro.data.feature.profile.model.JiraProfileDto
import sk.andrei.jiratimetrackerpro.domain.feature.profile.model.JiraProfile
import sk.andrei.jiratimetrackerpro.domain.feature.profile.repository.JiraProfileRepository
import sk.andrei.jiratimetrackerpro.data.core.network.NetworkClient
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.repository.GenericValueRepository
import sk.andrei.jiratimetrackerpro.data.feature.profile.model.ProfileId

class JiraProfileRepositoryImpl(
    private val networkClient: NetworkClient,
    private val genericValueRepository: GenericValueRepository
) : JiraProfileRepository {

    override suspend fun updateJiraProfile(): Result<Unit> {
        return networkClient.get<JiraProfileDto>("myself").fold(
            onSuccess = {
                genericValueRepository.save(ProfileId.DISPLAY_NAME, it.displayName)
                return Result.success(Unit)
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }

    override suspend fun getJiraProfile(): Result<JiraProfile> {
        val displayName = genericValueRepository.load(ProfileId.DISPLAY_NAME)
        return if (displayName?.value_ == null) {
            Result.failure(RuntimeException("Name not stored"))
        } else {
            Result.success(JiraProfile(displayName = displayName.value_))
        }
    }
}
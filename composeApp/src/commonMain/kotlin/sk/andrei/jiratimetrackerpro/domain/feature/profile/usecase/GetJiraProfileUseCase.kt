package sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.OutputUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.profile.model.JiraProfile
import sk.andrei.jiratimetrackerpro.domain.feature.profile.repository.JiraProfileRepository

class GetJiraProfileUseCase(
    private val repository: JiraProfileRepository
): OutputUseCase<JiraProfile>() {

    override suspend fun execute(input: Unit): Result<JiraProfile> {
        return repository.getJiraProfile()
    }

}
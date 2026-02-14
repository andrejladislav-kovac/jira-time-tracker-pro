package sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.OutputUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.profile.repository.JiraProfileRepository

class UpdateJiraProfileUseCase(
    private val repository: JiraProfileRepository
): OutputUseCase<Unit>() {

    override suspend fun execute(input: Unit): Result<Unit> {
        return repository.updateJiraProfile()
    }

}
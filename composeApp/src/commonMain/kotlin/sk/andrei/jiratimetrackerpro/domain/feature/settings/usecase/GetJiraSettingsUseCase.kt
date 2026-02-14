package sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.OutputUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.user.model.User
import sk.andrei.jiratimetrackerpro.domain.feature.user.repository.UserRepository

class GetJiraSettingsUseCase(
    private val repository: UserRepository,
): OutputUseCase<User>() {

    override suspend fun execute(input: Unit): Result<User> = repository.findById(Unit)

}
package sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.InputUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.user.model.User
import sk.andrei.jiratimetrackerpro.domain.feature.user.repository.UserRepository

class UpdateUserUseCase(
    private val repository: UserRepository,
): InputUseCase<User>() {

    override suspend fun execute(input: User): Result<Unit> {
        repository.save(input)
        return Result.success(Unit)
    }

}
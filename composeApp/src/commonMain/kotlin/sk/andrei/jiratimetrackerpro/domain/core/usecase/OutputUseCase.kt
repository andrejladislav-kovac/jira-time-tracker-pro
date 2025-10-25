package sk.andrei.jiratimetrackerpro.domain.core.usecase

abstract class OutputUseCase<O> : UseCase<Unit, O>() {

    suspend operator fun invoke(): Result<O> = execute(Unit)

}
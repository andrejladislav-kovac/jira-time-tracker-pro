package sk.andrei.jiratimetrackerpro.domain.core.usecase

abstract class UseCase<I, O> {

    suspend operator fun invoke(input: I): Result<O> = execute(input)

    protected abstract suspend fun execute(input: I): Result<O>

}

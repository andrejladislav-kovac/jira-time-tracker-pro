package sk.andrei.jiratimetrackerpro.domain.feature.issue.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.UseCase
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue
import sk.andrei.jiratimetrackerpro.domain.feature.issue.repository.IssueRepository

class GetIssuesUseCase(
    val repository: IssueRepository
): UseCase<GetIssuesUseCase.Params, List<Issue>>() {

    override suspend fun execute(input: Params): Result<List<Issue>> {
        return repository.findAll(fresh = input.shouldFetch)
    }

    data class Params(
        val shouldFetch: Boolean = false
    )

}
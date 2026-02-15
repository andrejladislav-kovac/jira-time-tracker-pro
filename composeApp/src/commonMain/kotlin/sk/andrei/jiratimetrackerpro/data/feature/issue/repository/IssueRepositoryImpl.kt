package sk.andrei.jiratimetrackerpro.data.feature.issue.repository

import io.ktor.client.request.parameter
import sk.andrei.jiratimetrackerpro.data.core.mapper.mapOrConnectionFailure
import sk.andrei.jiratimetrackerpro.data.core.network.NetworkClient
import sk.andrei.jiratimetrackerpro.data.core.repository.CachedReadableRepository
import sk.andrei.jiratimetrackerpro.data.feature.issue.mapper.toDomain
import sk.andrei.jiratimetrackerpro.data.feature.issue.model.SearchResponseDto
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue
import sk.andrei.jiratimetrackerpro.domain.feature.issue.repository.IssueRepository

class IssueRepositoryImpl(
    private val networkClient: NetworkClient
): IssueRepository, CachedReadableRepository<Issue, String>() {

    override suspend fun findAllFresh(): Result<List<Issue>> {
        return networkClient.get<SearchResponseDto>("/search/jql") {
            parameter("jql", "assignee = currentUser() AND resolution = Unresolved")
            parameter("fields", "summary,status,timespent,priority")
        }.mapOrConnectionFailure(SearchResponseDto::toDomain)
    }

}
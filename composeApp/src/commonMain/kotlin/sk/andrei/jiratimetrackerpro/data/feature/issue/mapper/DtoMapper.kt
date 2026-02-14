package sk.andrei.jiratimetrackerpro.data.feature.issue.mapper

import sk.andrei.jiratimetrackerpro.data.feature.issue.model.IssueDto
import sk.andrei.jiratimetrackerpro.data.feature.issue.model.SearchResponseDto
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue

fun SearchResponseDto.toDomain() = issues.map { it.toDomain() }


fun IssueDto.toDomain() = Issue(
    id = id,
    key = key,
    title = fields.summary,
    status = fields.status.name.toDomain()
)

fun IssueDto.StatusName?.toDomain() = when(this) {
    null -> Issue.Status.UNKNOWN
    IssueDto.StatusName.TODO -> Issue.Status.TODO
    IssueDto.StatusName.IN_PROGRESS -> Issue.Status.IN_PROGRESS
    IssueDto.StatusName.CODE_REVIEW -> Issue.Status.CODE_REVIEW
    IssueDto.StatusName.DONE -> Issue.Status.DONE
}
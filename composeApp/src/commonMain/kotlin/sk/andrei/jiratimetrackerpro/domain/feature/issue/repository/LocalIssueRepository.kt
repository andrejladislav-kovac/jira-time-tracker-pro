package sk.andrei.jiratimetrackerpro.domain.feature.issue.repository

import sk.andrei.jiratimetrackerpro.domain.core.FullAccessRepository
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue

interface LocalIssueRepository: FullAccessRepository<Issue, Long>
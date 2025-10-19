package sk.andrei.jiratimetrackerpro.domain.feature.issue.repository

import sk.andrei.jiratimetrackerpro.domain.core.ReadAccessRepository
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue

interface RemoteIssueRepository: ReadAccessRepository<Issue, Long>
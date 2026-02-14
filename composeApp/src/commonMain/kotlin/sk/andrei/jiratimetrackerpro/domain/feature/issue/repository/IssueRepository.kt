package sk.andrei.jiratimetrackerpro.domain.feature.issue.repository

import sk.andrei.jiratimetrackerpro.domain.core.repository.ReadableRepository
import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue

interface IssueRepository: ReadableRepository<Issue, String>
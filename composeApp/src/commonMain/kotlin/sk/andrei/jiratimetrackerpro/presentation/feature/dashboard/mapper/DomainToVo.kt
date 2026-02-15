package sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.mapper

import sk.andrei.jiratimetrackerpro.domain.feature.issue.model.Issue
import sk.andrei.jiratimetrackerpro.presentation.feature.dashboard.ui.IssuePriorityVo

fun Issue.Priority.toVo() = when(this) {
    Issue.Priority.LOWEST -> IssuePriorityVo.LOWEST
    Issue.Priority.LOW -> IssuePriorityVo.LOW
    Issue.Priority.MEDIUM -> IssuePriorityVo.MEDIUM
    Issue.Priority.HIGH -> IssuePriorityVo.HIGH
    Issue.Priority.HIGHER -> IssuePriorityVo.HIGHER
    Issue.Priority.HIGHEST -> IssuePriorityVo.HIGHEST

}
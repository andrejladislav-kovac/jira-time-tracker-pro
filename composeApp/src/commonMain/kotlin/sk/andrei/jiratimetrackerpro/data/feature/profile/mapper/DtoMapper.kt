package sk.andrei.jiratimetrackerpro.data.feature.profile.mapper

import sk.andrei.jiratimetrackerpro.data.feature.profile.model.JiraProfileDto
import sk.andrei.jiratimetrackerpro.domain.feature.profile.model.JiraProfile

fun JiraProfileDto.toDomain() = JiraProfile(
    displayName = displayName
)

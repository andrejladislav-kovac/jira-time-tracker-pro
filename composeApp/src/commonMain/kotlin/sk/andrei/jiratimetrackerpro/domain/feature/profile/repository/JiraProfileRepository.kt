package sk.andrei.jiratimetrackerpro.domain.feature.profile.repository

import sk.andrei.jiratimetrackerpro.domain.feature.profile.model.JiraProfile

interface JiraProfileRepository {

    suspend fun updateJiraProfile(): Result<Unit>

    suspend fun getJiraProfile(): Result<JiraProfile>

}
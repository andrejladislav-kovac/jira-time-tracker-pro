package sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.OutputUseCase
import sk.andrei.jiratimetrackerpro.domain.core.usecase.UseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.SettingsRepository

class GetJiraSettingsUseCase(
    private val repository: SettingsRepository,
): OutputUseCase<JiraSettings>() {

    override suspend fun execute(input: Unit): Result<JiraSettings> {
        return Result.success(repository.getJiraSettings())
    }

}
package sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase

import sk.andrei.jiratimetrackerpro.domain.core.usecase.InputUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings
import sk.andrei.jiratimetrackerpro.domain.feature.settings.repository.SettingsRepository

class SaveJiraSettingsUseCase(
    private val repository: SettingsRepository,
): InputUseCase<JiraSettings>() {

    override suspend fun execute(input: JiraSettings): Result<Unit> {
        repository.saveJiraSettings(input)
        return Result.success(Unit)
    }

}
package sk.andrei.jiratimetrackerpro.domain

import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.GetJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.SaveJiraSettingsUseCase

val domainModule = module {

    factory {
        SaveJiraSettingsUseCase(
            repository = get()
        )
    }

    factory {
        GetJiraSettingsUseCase(
            repository = get()
        )
    }

}
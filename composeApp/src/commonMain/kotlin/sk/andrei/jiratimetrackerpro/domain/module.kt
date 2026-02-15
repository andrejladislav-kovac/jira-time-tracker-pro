package sk.andrei.jiratimetrackerpro.domain

import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.domain.feature.issue.usecase.GetIssuesUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase.GetJiraProfileUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase.UpdateJiraProfileUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.GetJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.UpdateUserUseCase

val domainModule = module {

    factory {
        UpdateUserUseCase(
            repository = get()
        )
    }

    factory {
        GetJiraSettingsUseCase(
            repository = get()
        )
    }

    factory {
        UpdateJiraProfileUseCase(
            repository = get()
        )
    }

    factory {
        GetIssuesUseCase(
            repository = get()
        )
    }

    factory {
        GetJiraProfileUseCase(
            repository = get()
        )
    }

}
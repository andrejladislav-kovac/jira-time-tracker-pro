package sk.andrei.jiratimetrackerpro.presentation.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.builtins.serializer
import org.koin.core.component.inject
import sk.andrei.jiratimetrackerpro.domain.feature.settings.model.JiraSettings
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.GetJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.SaveJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.presentation.core.BaseComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.common.passwordinput.PasswordInputComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput.TextInputComponentImpl

class SettingsComponentImpl(
    context: ComponentContext
): SettingsComponent, BaseComponent<Unit>(
    context = context,
    initialState = Unit,
    serializer = Unit.serializer(),
) {
    override val urlComponent = TextInputComponentImpl(context, "settings_url")
    override val tokenComponent = PasswordInputComponentImpl(context, "settings_token")

    private val getJiraSettings: GetJiraSettingsUseCase by inject()
    private val saveJiraSettings: SaveJiraSettingsUseCase by inject()

    init {
        doInBackground {
            getJiraSettings().onSuccess {
                urlComponent.onChange(it.url ?: "", false)
                tokenComponent.onChange(it.token ?: "", false)
            }
        }
    }

    override fun onSaveClick() {
        doInBackground {
            saveJiraSettings(
                JiraSettings(
                    url = urlComponent.value,
                    token = tokenComponent.value
                )
            )
        }
    }

    override fun onScanClick() {

    }

    override fun onBackClick() {


    }
}
package sk.andrei.jiratimetrackerpro.presentation.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.builtins.serializer
import org.koin.core.component.inject
import sk.andrei.jiratimetrackerpro.domain.feature.profile.usecase.UpdateJiraProfileUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.GetJiraSettingsUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.settings.usecase.UpdateUserUseCase
import sk.andrei.jiratimetrackerpro.domain.feature.user.model.User
import sk.andrei.jiratimetrackerpro.presentation.core.component.BaseComponent
import sk.andrei.jiratimetrackerpro.presentation.core.component.passwordinput.PasswordInputComponentImpl
import sk.andrei.jiratimetrackerpro.presentation.core.component.textinput.TextInputComponentImpl
import kotlin.getValue

class SettingsComponentImpl(
    context: ComponentContext,
    private val goBack: () -> Unit,
) : SettingsComponent, BaseComponent<Unit>(
    context = context,
    initialState = Unit,
    serializer = Unit.serializer(),
) {

    override val jiraSiteComponent = TextInputComponentImpl(
        context,
        "settings_jira_site",
        ::validator
    )
    override val jiraEmailComponent = TextInputComponentImpl(
        context,
        "settings_jira_email",
        ::validator
    )
    override val jiraTokenComponent = PasswordInputComponentImpl(
        context,
        "settings_jira_token",
        ::validator
    )

    private val getUser: GetJiraSettingsUseCase by inject()
    private val updateProfile: UpdateJiraProfileUseCase by inject()
    private val saveUser: UpdateUserUseCase by inject()

    init {
        doInBackground {
            getUser().onSuccess {
                jiraSiteComponent.onChange(it.organization, false)
                jiraEmailComponent.onChange(it.email, false)
                jiraTokenComponent.onChange(it.token, false)
            }
        }
    }

    override fun onSaveClick() {
        if (!validateComponents(jiraSiteComponent, jiraEmailComponent, jiraTokenComponent)) {
            return
        }
        val user = User(
            organization = jiraSiteComponent.value,
            email = jiraEmailComponent.value,
            token = jiraTokenComponent.value,
        )
        doInBackground {
            saveUser(user)
            updateProfile().onSuccess {
                doInForeground(goBack)
            }.onFailure {
                println(it)
            }
        }
    }

    override fun onScanClick() {

    }

    override fun onBackClick() = goBack()

    private fun validator(value: String) = value.isNotBlank()
}
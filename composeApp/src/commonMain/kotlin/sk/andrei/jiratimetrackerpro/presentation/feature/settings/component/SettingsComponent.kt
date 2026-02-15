package sk.andrei.jiratimetrackerpro.presentation.feature.settings.component

import sk.andrei.jiratimetrackerpro.presentation.core.component.passwordinput.PasswordInputComponent
import sk.andrei.jiratimetrackerpro.presentation.core.component.textinput.TextInputComponent

interface SettingsComponent {

    val jiraSiteComponent: TextInputComponent
    val jiraEmailComponent: TextInputComponent

    val jiraTokenComponent: PasswordInputComponent

    fun onBackClick()

    fun onSaveClick()

    fun onScanClick()

}
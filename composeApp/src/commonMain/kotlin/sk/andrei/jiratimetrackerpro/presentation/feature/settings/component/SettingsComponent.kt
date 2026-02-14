package sk.andrei.jiratimetrackerpro.presentation.feature.settings.component

import sk.andrei.jiratimetrackerpro.presentation.feature.common.passwordinput.PasswordInputComponent
import sk.andrei.jiratimetrackerpro.presentation.feature.common.textinput.TextInputComponent

interface SettingsComponent {

    val jiraSiteComponent: TextInputComponent
    val jiraEmailComponent: TextInputComponent

    val jiraTokenComponent: PasswordInputComponent

    fun onBackClick()

    fun onSaveClick()

    fun onScanClick()

}
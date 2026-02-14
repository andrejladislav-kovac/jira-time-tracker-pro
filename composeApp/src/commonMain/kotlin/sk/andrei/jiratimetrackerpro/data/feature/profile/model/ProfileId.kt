package sk.andrei.jiratimetrackerpro.data.feature.profile.model

import sk.andrei.jiratimetrackerpro.data.feature.common.settings.model.GenericValueId

enum class ProfileId(override val id: String): GenericValueId {
    DISPLAY_NAME("profile_display_name")
}
package sk.andrei.jiratimetrackerpro.data.feature.common.settings.mapper

import sk.andrei.jiratimetrackerpro.data.database.SettingEntity
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.model.GenericValueId

fun GenericValueId.toEntity(value: String?) = SettingEntity(id, value)

fun List<SettingEntity>.findValue(genericValueId: GenericValueId) = find { it.id == genericValueId.id }?.value_
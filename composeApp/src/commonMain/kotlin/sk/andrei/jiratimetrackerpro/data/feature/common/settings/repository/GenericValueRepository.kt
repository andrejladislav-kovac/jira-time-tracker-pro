package sk.andrei.jiratimetrackerpro.data.feature.common.settings.repository

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import sk.andrei.jiratimetrackerpro.data.database.SettingEntity
import sk.andrei.jiratimetrackerpro.data.database.SettingEntityQueries
import sk.andrei.jiratimetrackerpro.data.feature.common.settings.model.GenericValueId

class GenericValueRepository(
    val settingsEntityQueries: SettingEntityQueries
) {

    suspend fun save(settings: List<SettingEntity>) = settings.forEach {
        settingsEntityQueries.upsert(it.id, it.value_)
    }

    suspend fun save(id: GenericValueId, value: String) =
        settingsEntityQueries.upsert(id.id, value)

    suspend inline fun <reified T> load(): List<SettingEntity> where T : Enum<T>, T : GenericValueId {
        val ids = enumValues<T>().map { it.id }
        return settingsEntityQueries.findByIds(ids).awaitAsList()
    }

    suspend fun load(id: GenericValueId): SettingEntity? {
        return settingsEntityQueries.findById(id.id).awaitAsOneOrNull()
    }
}
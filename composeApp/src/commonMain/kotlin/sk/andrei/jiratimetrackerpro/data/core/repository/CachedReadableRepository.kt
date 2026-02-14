package sk.andrei.jiratimetrackerpro.data.core.repository

import sk.andrei.jiratimetrackerpro.domain.core.CacheMissException
import sk.andrei.jiratimetrackerpro.domain.core.Model
import sk.andrei.jiratimetrackerpro.domain.core.asFailure
import sk.andrei.jiratimetrackerpro.domain.core.asSuccess
import sk.andrei.jiratimetrackerpro.domain.core.repository.ReadableRepository

abstract class CachedReadableRepository<T : Model<ID>, ID> : ReadableRepository<T, ID> {

    private var cache: Cache<T, ID>? = null

    override suspend fun findAll(fresh: Boolean): Result<List<T>> {
        return cache.let { cache ->
            if (fresh || cache == null) {
                findAllFresh().fold(
                    onSuccess = { list ->
                        val newCache = Cache(
                            list = list,
                            map = list.associateBy { it.id }
                        )
                        this.cache = newCache
                        newCache.list.asSuccess()
                    },
                    onFailure = {
                        it.asFailure<List<T>>()
                    }
                )
            } else {
                cache.list.asSuccess()
            }
        }
    }

    override suspend fun findById(id: ID): Result<T> {
        return cache?.map?.get(id)?.asSuccess() ?: CacheMissException().asFailure()
    }

    protected abstract suspend fun findAllFresh(): Result<List<T>>

    private data class Cache<T, ID>(
        val list: List<T>,
        val map: Map<ID, T>
    )
}
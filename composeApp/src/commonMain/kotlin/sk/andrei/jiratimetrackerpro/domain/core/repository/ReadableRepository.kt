package sk.andrei.jiratimetrackerpro.domain.core.repository

interface ReadableRepository<T, ID> {

    suspend fun findById(id: ID): Result<T>

    suspend fun findAll(fresh: Boolean = false): Result<List<T>>

}
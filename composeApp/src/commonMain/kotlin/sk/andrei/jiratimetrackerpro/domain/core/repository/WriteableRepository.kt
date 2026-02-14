package sk.andrei.jiratimetrackerpro.domain.core.repository

interface WriteableRepository<T> {

    suspend fun save(entity: T): Result<T>

}
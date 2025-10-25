package sk.andrei.jiratimetrackerpro.domain.core.repository

interface WriteAccessRepository<T> {

    fun save(entity: T): Result<T>

}
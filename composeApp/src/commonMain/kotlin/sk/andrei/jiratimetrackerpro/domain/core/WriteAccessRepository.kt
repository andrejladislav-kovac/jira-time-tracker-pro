package sk.andrei.jiratimetrackerpro.domain.core

interface WriteAccessRepository<T> {

    fun save(entity: T): Result<T>

}
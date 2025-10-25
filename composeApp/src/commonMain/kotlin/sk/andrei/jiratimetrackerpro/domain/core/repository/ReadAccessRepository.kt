package sk.andrei.jiratimetrackerpro.domain.core.repository

interface ReadAccessRepository<T, ID> {

    fun findById(id: ID): Result<T?>

    fun findAll(): Result<List<T>>

}
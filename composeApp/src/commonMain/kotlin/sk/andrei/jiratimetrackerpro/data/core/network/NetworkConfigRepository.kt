package sk.andrei.jiratimetrackerpro.data.core.network

interface NetworkConfigRepository {

    suspend fun get(): NetworkConfig

}
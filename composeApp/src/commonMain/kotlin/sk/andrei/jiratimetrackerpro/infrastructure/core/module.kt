package sk.andrei.jiratimetrackerpro.infrastructure.core

import io.ktor.client.HttpClient
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.infrastructure.feature.network.createHttpClient

val infrastructureModule = module {

    single<HttpClient> {
        createHttpClient()
    }

}
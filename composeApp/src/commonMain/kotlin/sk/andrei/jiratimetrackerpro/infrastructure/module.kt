package sk.andrei.jiratimetrackerpro.infrastructure

import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.infrastructure.feature.network.createHttpClient

val infrastructureModule = module {

    single<HttpClient> {
        createHttpClient()
    }

}

expect val platformInfrastructureModule: Module
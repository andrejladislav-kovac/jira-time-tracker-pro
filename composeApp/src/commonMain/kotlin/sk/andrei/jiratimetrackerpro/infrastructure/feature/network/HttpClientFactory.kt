package sk.andrei.jiratimetrackerpro.infrastructure.feature.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Creates HTTP Client with CIO engine
 */
fun createHttpClient() = HttpClient {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "TBD"
        }
        contentType(ContentType.Application.Json)
    }
}
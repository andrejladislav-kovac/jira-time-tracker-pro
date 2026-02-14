package sk.andrei.jiratimetrackerpro.data.core.network

import androidx.compose.ui.graphics.vector.addPathNodes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.basicAuth
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkClient(
    private val networkConfigRepository: NetworkConfigRepository
) {
    private var httpClient: HttpClient? = null

    suspend inline fun <reified I, reified O> post(path: String, body: I): Result<O> {
        val response = getHttpClient().post {
            addPathNodes(path)
            setBody(body)
        }
        return Result.success(response.body())
    }

    suspend inline fun <reified O> get(
        path: String,
        builder: HttpRequestBuilder.() -> Unit = {}
    ): Result<O> {
        return Result.success(getHttpClient().get {
            url(path.trimStart { it == '/' })
            builder()
        }.body<O>())
    }

    fun invalidate() {
        httpClient?.close()
        httpClient = null
    }

    suspend fun getHttpClient(): HttpClient {
        httpClient?.let {
            return it
        }
        val networkConfig = networkConfigRepository.get()
        val client = createHttpClient(networkConfig)
        httpClient = client
        return client
    }

    private fun createHttpClient(networkConfig: NetworkConfig) = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "${networkConfig.organization}.atlassian.net"
                port = 443
                path("rest/api/3/")
            }
            contentType(ContentType.Application.Json)
            basicAuth(networkConfig.username, networkConfig.password)
        }
    }

}
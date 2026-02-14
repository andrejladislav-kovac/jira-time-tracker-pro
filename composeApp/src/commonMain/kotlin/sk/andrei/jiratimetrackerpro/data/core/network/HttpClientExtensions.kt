package sk.andrei.jiratimetrackerpro.data.core.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

suspend inline fun <reified T, DOMAIN_MODEL> HttpResponse.toResult(toDomain: (T) -> DOMAIN_MODEL): Result<DOMAIN_MODEL> {
    return if (status.isSuccess()) {
        Result.success(toDomain(body()))
    } else {
        Result.failure(RuntimeException(status.description))
    }
}
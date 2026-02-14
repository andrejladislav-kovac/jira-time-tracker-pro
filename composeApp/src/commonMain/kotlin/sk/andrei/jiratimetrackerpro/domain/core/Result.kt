package sk.andrei.jiratimetrackerpro.domain.core

fun <T> T.asSuccess() = Result.success(this)

fun <T> Throwable.asFailure() = Result.failure<T>(this)

class CacheMissException : RuntimeException()
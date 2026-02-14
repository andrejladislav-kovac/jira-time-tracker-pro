package sk.andrei.jiratimetrackerpro.data.core.mapper

import sk.andrei.jiratimetrackerpro.domain.core.asFailure
import sk.andrei.jiratimetrackerpro.domain.core.asSuccess

fun <DTO, DOMAIN> Result<DTO>.mapOrConnectionFailure(mapper: (DTO) -> DOMAIN) = fold(
    onSuccess = { mapper(it).asSuccess() },
    onFailure = { RuntimeException("Could not fetch").asFailure() }
)
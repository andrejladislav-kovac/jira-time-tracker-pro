package sk.andrei.jiratimetrackerpro.domain.core.repository

interface FullAccessRepository<T, ID>:
        ReadAccessRepository<T, ID>,
        WriteAccessRepository<T>
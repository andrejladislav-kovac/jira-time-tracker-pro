package sk.andrei.jiratimetrackerpro.domain.core

interface FullAccessRepository<T, ID>:
        ReadAccessRepository<T, ID>,
        WriteAccessRepository<T>
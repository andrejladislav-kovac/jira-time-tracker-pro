package sk.andrei.jiratimetrackerpro.domain.core.repository

interface ReadWriteRepository<T, ID>:
        ReadableRepository<T, ID>,
        WriteableRepository<T>
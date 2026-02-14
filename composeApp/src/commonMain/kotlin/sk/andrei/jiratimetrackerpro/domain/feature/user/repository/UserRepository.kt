package sk.andrei.jiratimetrackerpro.domain.feature.user.repository

import sk.andrei.jiratimetrackerpro.domain.core.repository.ReadWriteRepository

import sk.andrei.jiratimetrackerpro.domain.feature.user.model.User

interface UserRepository: ReadWriteRepository<User, Unit>
package kz.arctan.movierecommendation.auth.domain

import kz.arctan.movierecommendation.auth.data.entity.User

interface UserRepository {
    suspend fun getUser(): Result<User>
}
package kz.arctan.movierecommendation.auth.domain

import kz.arctan.movierecommendation.auth.data.entity.User

interface UserRepository {
    suspend fun updateUser(pastUser: User, newUser: User)
    suspend fun deleteUser(user: User)

}
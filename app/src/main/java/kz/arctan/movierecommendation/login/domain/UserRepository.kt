package kz.arctan.movierecommendation.login.domain

import kz.arctan.movierecommendation.login.data.entity.User

interface UserRepository {
    suspend fun updateUser(pastUser: User, newUser: User)
    suspend fun deleteUser(user: User)

}
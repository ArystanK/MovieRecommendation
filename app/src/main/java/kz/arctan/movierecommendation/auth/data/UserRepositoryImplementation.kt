package kz.arctan.movierecommendation.auth.data

import kz.arctan.movierecommendation.auth.data.entity.User
import kz.arctan.movierecommendation.auth.domain.UserRepository

class UserRepositoryImplementation : UserRepository {
    override suspend fun updateUser(pastUser: User, newUser: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }
}
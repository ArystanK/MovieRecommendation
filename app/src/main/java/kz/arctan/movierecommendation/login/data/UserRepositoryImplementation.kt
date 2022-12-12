package kz.arctan.movierecommendation.login.data

import kz.arctan.movierecommendation.login.data.entity.User
import kz.arctan.movierecommendation.login.domain.UserRepository

class UserRepositoryImplementation : UserRepository {
    override suspend fun updateUser(pastUser: User, newUser: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }
}
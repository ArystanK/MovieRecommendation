package kz.arctan.movierecommendation.auth.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.*
import kz.arctan.movierecommendation.auth.data.entity.User
import kz.arctan.movierecommendation.auth.data.remote.UserApi
import kz.arctan.movierecommendation.auth.domain.UserRepository
import kz.arctan.movierecommendation.common.di.jwtKey
import javax.inject.Inject
import kotlin.Exception

object UserNotRegisteredException : Exception("User Not Registered")
object UserNotFoundException : Exception("User not found")

class UserRepositoryImplementation @Inject constructor(
    private val userApi: UserApi,
    private val dataStore: DataStore<Preferences>,
) : UserRepository {
    override suspend fun getUser(): Result<User> {
        try {
            val preferences = dataStore.data.last()
            val key = preferences[jwtKey] ?: return Result.failure(UserNotRegisteredException)
            val userResponse = userApi.user(key)
            if (userResponse.isSuccessful)
                return userResponse.body()?.let { Result.success(it) }
                    ?: Result.failure(UserNotFoundException)
            return Result.failure(UserNotFoundException)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}
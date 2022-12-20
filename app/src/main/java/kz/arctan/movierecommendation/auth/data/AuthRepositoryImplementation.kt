package kz.arctan.movierecommendation.auth.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.runBlocking
import kz.arctan.movierecommendation.auth.data.entity.LoginDto
import kz.arctan.movierecommendation.auth.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.auth.data.entity.RegisterDto
import kz.arctan.movierecommendation.auth.data.remote.AuthApi
import kz.arctan.movierecommendation.auth.di.AuthModule
import kz.arctan.movierecommendation.auth.domain.AuthRepository
import kz.arctan.movierecommendation.common.di.CommonModule
import kz.arctan.movierecommendation.common.di.jwtKey
import java.lang.Exception
import javax.inject.Inject

class RegisterError(message: String) : Exception(message)
class LoginError(message: String) : Exception(message)

class AuthRepositoryImplementation @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val authApi: AuthApi,
) : AuthRepository {
    override suspend fun login(loginDto: LoginDto): Result<LoginResponseDto> {
        return try {
            val response = authApi.login(loginDto)
            response.body()?.let { loginResponse ->
                dataStore.edit { it[jwtKey] = loginResponse.userId }
                Result.success(loginResponse)
            } ?: Result.failure(LoginError("${response.code()}: ${response.message()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(registerDto: RegisterDto): Result<Unit> {
        return try {
            val result = authApi.register(registerDto)
            if (result.isSuccessful) Result.success(Unit)
            else Result.failure(RegisterError(result.message()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

fun main(): Unit = runBlocking {
    val authApi = AuthModule.provideAuthApi()
    val result = authApi.login(LoginDto("example@example.com", "Qqwerty1!"))
    println(result.raw())
}
package kz.arctan.movierecommendation.login.data

import kz.arctan.movierecommendation.login.data.entity.LoginDto
import kz.arctan.movierecommendation.login.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.login.data.entity.RegisterDto
import kz.arctan.movierecommendation.login.domain.AuthRepository

class AuthRepositoryImplementation : AuthRepository {
    override suspend fun login(loginDto: LoginDto): LoginResponseDto {
        TODO("Not yet implemented")
    }

    override suspend fun register(registerDto: RegisterDto): LoginResponseDto {
        TODO("Not yet implemented")
    }
}
package kz.arctan.movierecommendation.auth.data

import kz.arctan.movierecommendation.auth.data.entity.LoginDto
import kz.arctan.movierecommendation.auth.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.auth.data.entity.RegisterDto
import kz.arctan.movierecommendation.auth.domain.AuthRepository

class AuthRepositoryImplementation : AuthRepository {
    override suspend fun login(loginDto: LoginDto): LoginResponseDto {
        TODO("Not yet implemented")
    }

    override suspend fun register(registerDto: RegisterDto): LoginResponseDto {
        TODO("Not yet implemented")
    }
}
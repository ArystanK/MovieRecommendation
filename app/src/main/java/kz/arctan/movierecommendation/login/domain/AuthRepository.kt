package kz.arctan.movierecommendation.login.domain

import kz.arctan.movierecommendation.login.data.entity.LoginDto
import kz.arctan.movierecommendation.login.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.login.data.entity.RegisterDto

interface AuthRepository {
    suspend fun login(loginDto: LoginDto): LoginResponseDto
    suspend fun register(registerDto: RegisterDto): LoginResponseDto
}
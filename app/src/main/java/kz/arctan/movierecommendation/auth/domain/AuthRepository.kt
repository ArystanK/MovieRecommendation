package kz.arctan.movierecommendation.auth.domain

import kz.arctan.movierecommendation.auth.data.entity.LoginDto
import kz.arctan.movierecommendation.auth.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.auth.data.entity.RegisterDto

interface AuthRepository {
    suspend fun login(loginDto: LoginDto): LoginResponseDto
    suspend fun register(registerDto: RegisterDto): LoginResponseDto
}
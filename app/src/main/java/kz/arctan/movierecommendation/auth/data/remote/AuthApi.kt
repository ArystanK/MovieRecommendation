package kz.arctan.movierecommendation.auth.data.remote

import kz.arctan.movierecommendation.auth.data.entity.LoginDto
import kz.arctan.movierecommendation.auth.data.entity.LoginResponseDto
import kz.arctan.movierecommendation.auth.data.entity.RegisterDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/v1/auth/login")
    suspend fun login(@Body loginDto: LoginDto): Response<LoginResponseDto>

    @POST("/api/v1/auth/register")
    suspend fun register(@Body registerDto: RegisterDto): Response<String>
}
package kz.arctan.movierecommendation.auth.data.remote

import kz.arctan.movierecommendation.auth.data.entity.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/api/v1/user/{id}")
    fun user(@Path("id") userId: String): Response<User>
}
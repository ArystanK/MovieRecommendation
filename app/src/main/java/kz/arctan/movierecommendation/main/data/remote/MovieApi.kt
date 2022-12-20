package kz.arctan.movierecommendation.main.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kz.arctan.movierecommendation.main.data.entity.MovieDto
import kz.arctan.movierecommendation.main.di.MainModule
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("/api/v1/movie/{pageId}")
    suspend fun getMovies(@Path("pageId") page: Int): List<MovieDto>

    @GET("/api/v1/movie/byid/{id}")
    suspend fun getMovieById(@Path("id") id: String): MovieDto

    @GET("/api/v1/movie/getgenres/all/genres/")
    suspend fun getAllGenres(): List<String>
}

fun main(): Unit = runBlocking {
    val movieApi = MainModule.getMovieApi()
    launch {
        movieApi.getMovies(1).forEach {
            println(it)
        }
    }
    launch {
        println(movieApi.getMovieById("1"))
    }
}

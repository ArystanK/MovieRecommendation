package kz.arctan.movierecommendation.main.domain

import kz.arctan.movierecommendation.main.data.entity.MovieDto

interface MovieRepository {
    suspend fun getMovieById(id: String): Result<MovieDto>

    suspend fun getMoviesByPage(pageId: Int): Result<List<MovieDto>>

    suspend fun getAllGenres(): Result<List<String>>
}
package kz.arctan.movierecommendation.main.data

import kz.arctan.movierecommendation.main.data.entity.MovieDto
import kz.arctan.movierecommendation.main.data.remote.MovieApi
import kz.arctan.movierecommendation.main.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(
    private val movieApi: MovieApi,
) : MovieRepository {

    override suspend fun getMovieById(id: String): Result<MovieDto> =
        try {
            val movie = movieApi.getMovieById(id)
            Result.success(movie)
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun getMoviesByPage(pageId: Int): Result<List<MovieDto>> =
        try {
            val movies = movieApi.getMovies(pageId)
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun getAllGenres(): Result<List<String>> =
        try {
            Result.success(movieApi.getAllGenres())
        } catch (e: Exception) {
            Result.failure(e)
        }

}
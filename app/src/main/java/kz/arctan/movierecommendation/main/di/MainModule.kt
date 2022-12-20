package kz.arctan.movierecommendation.main.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kz.arctan.movierecommendation.main.data.MovieRepositoryImplementation
import kz.arctan.movierecommendation.main.data.remote.MovieApi
import kz.arctan.movierecommendation.main.domain.MovieRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {
    @Provides
    @ViewModelScoped
    fun getMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl("https://movierecommendationappknu.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @ViewModelScoped
    fun getMovieRepository(movieApi: MovieApi): MovieRepository {
        return MovieRepositoryImplementation(movieApi)
    }
}
package kz.arctan.movierecommendation.auth.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kz.arctan.movierecommendation.auth.data.AuthRepositoryImplementation
import kz.arctan.movierecommendation.auth.data.UserRepositoryImplementation
import kz.arctan.movierecommendation.auth.data.remote.AuthApi
import kz.arctan.movierecommendation.auth.data.remote.UserApi
import kz.arctan.movierecommendation.auth.domain.AuthRepository
import kz.arctan.movierecommendation.auth.domain.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {
    @Provides
    @ViewModelScoped
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl("https://movierecommendationappknu.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @ViewModelScoped
    fun provideUserApi(): UserApi {
        return Retrofit.Builder()
            .baseUrl("https://movierecommendationappknu.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @ViewModelScoped
    fun provideUserRepository(
        userApi: UserApi,
        dataStore: DataStore<Preferences>,
    ): UserRepository = UserRepositoryImplementation(userApi, dataStore)

    @Provides
    @ViewModelScoped
    fun provideAuthRepository(
        authApi: AuthApi,
        dataStore: DataStore<Preferences>,
    ): AuthRepository = AuthRepositoryImplementation(dataStore, authApi)
}

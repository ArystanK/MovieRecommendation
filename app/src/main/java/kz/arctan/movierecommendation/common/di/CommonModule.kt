package kz.arctan.movierecommendation.common.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val jwtKey = stringPreferencesKey("jwt")

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) = context.dataStore
}
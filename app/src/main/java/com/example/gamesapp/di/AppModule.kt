package com.example.gamesapp.di

import com.example.gamesapp.BuildConfig
import com.example.gamesapp.data.api.GamesApi
import com.example.gamesapp.data.repository.GamesRepositoryImpl
import com.example.gamesapp.domain.repository.GamesRepository
import com.example.gamesapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
            addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val originalHttpUrl: HttpUrl = original.url

                    val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("key", "19ca60b40d554ef0a18a44df5033907f")
                        .build()
                    val requestBuilder: Request.Builder = original.newBuilder()
                        .url(url)
                    val request: Request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })
        }.build()
    }
    @Provides
    @Singleton
    fun provideGamesApi(okHttpClient: OkHttpClient): GamesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(GamesApi::class.java)
    }
    @Provides
    @Singleton
    fun provideGamesRepository(gamesApi: GamesApi): GamesRepository {
        return GamesRepositoryImpl(gamesApi)
    }
}
package com.jax.movies.data.network.api

import com.jax.movies.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieFactory {

    private const val BASE_URL = "https://api.kinopoisk.dev/"
    private const val API_KEY_HEADER = "X-API-KEY"
    private const val HEADER_ACCEPT_NAME = "Accept"
    private const val HEADER_ACCEPT_VALUE = "application/json"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(API_KEY_HEADER, BuildConfig.MOVIE_API_KEY)
                .addHeader(HEADER_ACCEPT_NAME, HEADER_ACCEPT_VALUE)
                .build()
            chain.proceed(request)
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService: MovieService = retrofit.create(MovieService::class.java)
}

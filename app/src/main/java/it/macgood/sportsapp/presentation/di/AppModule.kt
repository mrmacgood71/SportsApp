package it.macgood.sportsapp.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.macgood.data.api.AllSportsBasketballApi
import it.macgood.data.api.AllSportsFootballApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl() = "https://apiv2.allsportsapi.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(provideHttpLoggingInterceptor())
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        return logging
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideBasketballApiService(retrofit: Retrofit): AllSportsBasketballApi
                                            = retrofit.create(AllSportsBasketballApi::class.java)

    @Provides
    @Singleton
    fun provideFootballApiService(retrofit: Retrofit): AllSportsFootballApi
                                            = retrofit.create(AllSportsFootballApi::class.java)
}
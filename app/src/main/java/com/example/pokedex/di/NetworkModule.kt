package com.example.pokedex.di

import com.example.pokedex.data.sources.remote.PokemonApi
import com.example.pokedex.data.utils.PokemonDeserializer
import com.example.pokedex.domain.models.Pokemon
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).setLenient().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit) : PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }


}
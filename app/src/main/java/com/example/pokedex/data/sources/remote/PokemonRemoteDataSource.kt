package com.example.pokedex.data.sources.remote

import com.google.gson.Gson
import retrofit2.Retrofit

class PokemonRemoteDataSource {
    fun check() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()

        val pokemonService: PokemonApiService = retrofit.create(PokemonApiService::class.java)
    }
}
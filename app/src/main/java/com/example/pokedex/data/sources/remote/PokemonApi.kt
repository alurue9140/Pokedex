package com.example.pokedex.data.sources.remote

import com.example.pokedex.domain.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokemonApi {
    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<Pokemon>
}
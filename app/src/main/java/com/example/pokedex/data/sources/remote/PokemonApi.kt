package com.example.pokedex.data.sources.remote

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val DEFAULT_LIMIT = 20

interface PokemonApi {
    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<Pokemon>

    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon")
    fun getPokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit : Int = DEFAULT_LIMIT
    ): Call<PokemonList>
}
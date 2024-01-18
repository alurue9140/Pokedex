package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.utils.PokemonDeserializer
import com.example.pokedex.domain.models.Pokemon
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeApi {

    val gSon = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .build()

    val pokemonService: PokemonApi by lazy { retrofit.create(PokemonApi::class.java) }



}
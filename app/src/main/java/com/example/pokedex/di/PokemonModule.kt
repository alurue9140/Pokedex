package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.data.repositories.PokemonRepository
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonFromJsonRepository
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonModule {

    @Binds
    abstract fun bindPokemonRepository(pokemonRepository: PokemonFromJsonRepository): PokemonRepository



}

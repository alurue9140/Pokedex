package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentTopAppBar(color: Color, id: Int) {

    TopAppBar(
        title = { Box (modifier = Modifier.fillMaxWidth()){
            Text(text = "Pokedex", color = Color.White,fontSize = 17.sp, modifier = Modifier.align(Alignment.TopStart))
            Text(text = "#$id", color = Color.White,fontSize = 17.sp, modifier = Modifier.align(Alignment.TopEnd))
        }},
        colors = TopAppBarDefaults.mediumTopAppBarColors(color),
        navigationIcon = { Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Menu", tint = Color.White, modifier = Modifier.padding(10.dp)) },
    )
}
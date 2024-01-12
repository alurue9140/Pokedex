package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponentTitle(str : String) {
    Text(text = str, color = Color.White, fontSize = 25.sp,letterSpacing = 1.sp, modifier = Modifier.padding(top = 10.dp))
}
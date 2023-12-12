package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponentName(name : String) {
    Text(
        modifier = Modifier.padding(top = 10.dp, bottom = 17.dp, start = 5.dp, end = 5.dp),
        text = name,
        color = Color.White,
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp,
        textAlign = TextAlign.Center
    )
}
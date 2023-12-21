package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.models.Pokemon

@Composable
fun ComponentWeightHeight(pokemon: Pokemon) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(9.dp, top = 17.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        Column (
            modifier = Modifier
                .height(60.dp)
                .width(110.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "${pokemon.weight/10} KG", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "Weight", color = Color.Gray, fontSize = 17.sp)
        }

        Spacer(modifier = Modifier.padding(30.dp))

        Column (
            Modifier
                .height(60.dp)
                .width(110.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "${pokemon.height/10} M", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "Height", color = Color.Gray, fontSize = 17.sp)
        }
    }
}
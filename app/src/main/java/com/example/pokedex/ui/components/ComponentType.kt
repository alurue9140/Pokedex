package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.models.PokemonType

@Composable
fun ComponentType(firstType : PokemonType, secondType : PokemonType? = null) {

    if (secondType == null) {

        Row (modifier = Modifier
            .background(color = firstType.color, shape = RoundedCornerShape(20.dp))
            .padding(7.dp)
            .width(125.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = firstType.name, color = Color.White)
        }

    } else {

        Row {
            Row (modifier = Modifier
                .background(color = firstType.color, shape = RoundedCornerShape(20.dp))
                .padding(7.dp)
                .width(125.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(text = firstType.name, color = Color.White)
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Row (modifier = Modifier
                .background(color = secondType.color, shape = RoundedCornerShape(20.dp))
                .padding(7.dp)
                .width(125.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(text = secondType.name, color = Color.White)
            }
        }



    }
}
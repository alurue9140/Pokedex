package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.ATK
import com.example.pokedex.ui.theme.DEF
import com.example.pokedex.ui.theme.HP
import com.example.pokedex.ui.theme.SPD
import com.example.pokedex.ui.theme.SA
import com.example.pokedex.ui.theme.SD

@Composable
fun ComponentStats(hpProgress : Float, atkProgress : Float,defProgress : Float, sAProgress : Float, sDProgress : Float, spdProgress : Float) {


    Row (Modifier.fillMaxWidth()){

        Column (modifier = Modifier.padding(start = 40.dp)) {
            Stat("HP")
            Stat("ATK")
            Stat("DEF")
            Stat("SA")
            Stat("SD")
            Stat("SPD")
        }

        Column (modifier = Modifier.padding(start = 20.dp, end = 40.dp)) {
            LinearProgress(HP, hpProgress/255)
            LinearProgress(ATK, atkProgress/255)
            LinearProgress(DEF, defProgress/255)
            LinearProgress(SA, sAProgress/255)
            LinearProgress(SD, sDProgress/255)
            LinearProgress(SPD, spdProgress/255)

        }
    }
}

@Composable
private fun Stat(stat : String) {
    Text(text = stat, color = Color.Gray, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))

}

@Composable
private fun LinearProgress(color : Color, linearProgress : Float) {
    LinearProgressIndicator(progress = linearProgress, color = color, modifier = Modifier.padding(15.dp))

}
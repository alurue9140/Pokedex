import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.ui.theme.ATK
import com.example.pokedex.ui.theme.DEF
import com.example.pokedex.ui.theme.HP
import com.example.pokedex.ui.theme.SA
import com.example.pokedex.ui.theme.SD
import com.example.pokedex.ui.theme.SPD

@Composable
fun ComponentStatsCircular(pokemon: Pokemon) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgress(HP, pokemon.stats.hp, "HP")
            CircularProgress(ATK, pokemon.stats.atk, "ATK")
            CircularProgress(DEF, pokemon.stats.def, "DEF")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgress(SA, pokemon.stats.specialAttack, "SA")
            CircularProgress(SD, pokemon.stats.specialDefense, "SD")
            CircularProgress(SPD, pokemon.stats.spd, "SPD")
        }
    }
}

@Composable
private fun CircularProgress(color : Color, linearProgress : Float, statName : String) {

    Box(
        modifier = Modifier
            .size(110.dp)
            .padding(1.dp)
    ) {
        CircularProgressIndicator(
            progress = linearProgress / 255,
            color = color,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            strokeWidth = 4.dp
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = statName,
                color = Color.White
            )
            Text(
                text = "$linearProgress",
                color = Color.White
            )
        }
    }
}

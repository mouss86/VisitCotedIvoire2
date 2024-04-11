package fr.moussacherif.test1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Korhogo() {
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Toolbar(title = "Visit Côte d'Ivoire")
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            KorhogoVille()


        }
    }
}

@Composable
fun KorhogoVille() {
    Text(text = "Korhogo", modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 5.dp,),

        fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 30.sp, shadow = Shadow(
                color = Color.Green, blurRadius = 3f)
        )
    )
    Text(text = "est la troisième ville la plus peuplée de la Côte d'Ivoire," +
            " et la plus grande ville du nord du pays avec une population " +
            "de 440 926 habitants1." +
            "Surnommée la « cité du Poro »2 et située à 635 km d'Abidjan, " +
            "elle est la capitale du district des Savanes et " +
            "le chef-lieu de la région du Poro3." +
            "La ville est un point de passage stratégique vers le Mali et " +
            "le Burkina Faso. Korhogo est la capitale du peuple Sénoufo." +
            " Korhogo signifie en Sénoufo « héritage »"
    )
    LazyRow {
        
    }
    LazyColumn {
        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Meteo")

            }
        }
    }

}

@Preview
@Composable
fun KorhogoPreview() {
    Korhogo()
}

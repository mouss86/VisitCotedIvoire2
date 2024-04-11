package fr.moussacherif.test1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val bouakeImages = listOf(
    "antenne_bouake.jpeg",
    "nziparc_bouake.jpeg"
)

@Composable
fun Bouake() {
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
            BouakeVille()


        }
    }
}

@Composable
fun BouakeVille() {

    Text(text = "Bouake", modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 5.dp,),

        fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 30.sp, shadow = Shadow(
                color = Color.Green, blurRadius = 3f)
        )
    )
    Text(text = "appelée Gbékékro jusqu'en 1900, est une ville du centre" +
            " de la Côte d'Ivoire, située à 350 km environ d'Abidjan." +
            " Capitale du district de la Vallée du Bandama et chef-lieu" +
            " du département homonyme et de la région du Gbêkê, avec" +
            " une population d'environ 832 371 habitants2, " +
            "et environ 1,5 million d'habitants en comptant " +
            "toutes les localités agglomérées qui y sont rattachées," +
            " c'est la deuxième ville la plus peuplée du pays " +
            "après Abidjan.")
    LazyRow {
        items(bouakeImages) { imageName ->
            ImageListItem(imageName = imageName)
        }

    }
    LazyColumn {
        item { 
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Meteo")
            }
        }
    }
    
}

@Composable
fun ImageListItem(imageName: String) {
    val painter: Painter = painterResource(id = getBouakeImageResourceId(imageName))


    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(205.dp)
            .padding(4.dp)

    )
}

fun getBouakeImageResourceId(imageName: String): Int  {
    return when(imageName) {
        "antenne_bouake.jpeg" -> R.drawable.antenne_bouake
        "nziparc_bouake.jpeg" -> R . drawable . nziparc_bouake
        else -> R.drawable.noum_abidjan

    }
}


@Preview
@Composable
fun BouakePreview() {
    Bouake()
}

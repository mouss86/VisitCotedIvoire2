package fr.moussacherif.test1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val AssinieImages = listOf(
    "assinie_magic.jpeg",
    "assinie_tombenuit.jpeg",
    "assinie_paradi.jpeg",
    "assinie_zoo.jpeg",
    "assiniemara.jpeg",
    "assinie_hotel.jpeg",
    "assinie.embouchu.jpeg"
)

@Composable
fun Assinie() {
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
            AssinieVille()


        }
    }
}
@Composable
fun AssinieVille() {
    Text(text = "Assinie", modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 5.dp,),

        fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 30.sp, shadow = Shadow(
                color = Color.Green, blurRadius = 3f)
        )
    )
    Text(text = " est une station balnéaire de la Côte d'Ivoire au bord du golfe de Guinée. " +
            "Sa population est estimée à 21 941 habitants en 20213." +
            "L'embouchure de la lagune qui marque la fin de la presqu'île d'Assinie " +
            "est appelée La Passe, un endroit paradisiaque où ne se trouve ni restaurants," +
            " ni hôtels, et où l'on est en contact direct avec la nature." +
            "La localité est l'une des destinations privilégiées des Abidjanais " +
            "aisés pour le week-end. Elle a, d'ailleurs, constitué le lieu de tournage " +
            "du film culte Les Bronzés en 1978.")
    Spacer(modifier = Modifier.height(10.dp))
    LazyColumn {
        items(AssinieImages) { imageName ->
            AssinieImageItem(imageName = imageName)
        }
        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "meteo")
            }
        }

    }
    LazyColumn {

    }
}

@Composable
fun AssinieImageItem(imageName: String) {
    val resId = getAssinieResourceId(imageName)

    Box (modifier = Modifier
        .padding(vertical = 20.dp)
        .clickable { }

    ) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(400.dp)
                .absolutePadding(10.dp)
                .background(Color.Green)

                .fillMaxSize()
                .height(200.dp)


        )
    }
}

fun getAssinieResourceId(imageName: String): Int {
    return when (imageName) {
        "assinie_magic.jpeg" -> R.drawable.assinie_magic
        "assinie_tombenuit.jpeg" -> R.drawable.assinie_tombenuit
        "assinie_paradi.jpeg" -> R.drawable.assinie_paradi
        "assinie_zoo.jpeg" -> R.drawable.assinie_zoo
        "assiniemara_assinie.jpeg" -> R.drawable.assiniemara_assinie
        "assinie_hotel.jpeg" -> R.drawable.assinie_hotel
        "assinie.embouchu.jpeg" -> R.drawable.assinie_embouchu
        else -> R.drawable.assinie_paradi
    }

}


@Preview
@Composable
fun AssiniePreview() {
    Assinie()
}
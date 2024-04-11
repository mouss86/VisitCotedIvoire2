package fr.moussacherif.test1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.compose.rememberNavController


val SanPedroImages = listOf("ocean_sanp.jpeg",
    "spplage_sanpedro.jpeg",
    "piscine_naturellesp.jpeg",

)

@Composable
fun SanPedro() {
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
            SanPedrovILLE()


        }
    }
}

fun Toolbar(title: String) {

}


@Composable
fun SanPedrovILLE() {
    Text(text = "San Pedro", modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 5.dp,),

        fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 30.sp, shadow = Shadow(
                color = Color.Green, blurRadius = 3f)
        )
    )
    Text(text = "est une grande ville Bakwé, Kroumen et Wané du sud-ouest de la Côte d'Ivoire." +
            " Elle est capitale du district du Bas-Sassandra et administrativement " +
            "située dans la région de San-Pédro. La population est majoritairement d'ethnie Krou." +
            " Selon le RGPH 2021, elle comptait 390 654 habitants en 2021. " +
            "Ce qui en fait la 5e ville la plus peuplée de la Côte d'Ivoire" +
            " après Abidjan, Bouaké, Korhogo et Daloa devant Yamoussoukro." +
            "San-Pédro est la deuxième région économique de la Côte d'Ivoire " +
            "derrière la ville d'Abidjan grâce à son port et des zones industrielles. " +
            "En plus de son attractivité économique, elle reste l'une des zones touristiques " +
            "les plus prisées des populations. On y trouve de très belles plages dans la ville " +
            "et des villes environnantes à l'instar de Monogaga et Grand-Béréby qui sont " +
            "des lieux hautement touristiques.")
    LazyRow {
        items(SanPedroImages) { imageName ->
            CustomImageItem(imageName = imageName)
        }
    }
    LazyColumn {
        item { 
            Button(onClick = { /*TODO*/ }) {
                Text(text = "meteo")
            }
        }

    }
}
@Composable
fun CustomImageItem(imageName: String) {
    val painter: Painter = painterResource(id = getSanPedroImageResourceId(imageName))


    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(175.dp)
            .padding(4.dp)

    )
}

fun getSanPedroImageResourceId(imageName: String): Int {
    return when(imageName) {
        "ocean_sanp.jpeg.jpeg" -> R.drawable.ocean_sanp
        "spplage_sanpedro.jpeg" -> R.drawable.spplage_sanpedro
        "piscine_naturellesp.jpeg" -> R.drawable.piscine_naturellesp
        else -> R.drawable.ocean_sanp
    }

}


@Preview
@Composable
fun SanPedroPreview() {
    SanPedro()
}
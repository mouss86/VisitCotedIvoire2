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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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

val abidjanImages = listOf(
    "boignypont_abidjan.jpeg",
    "pyramide_abidjan.jpeg",
    "nouveaupalais_abidjan.jpeg",
    "lestour_abidjan.jpeg",
    "page_abidjan.jpeg",
    "expositionparc_abdjan.jpeg",
    "echangernou_abidjan.jpeg",
    "echandmarcory_abidjan.jpeg",
    "hotelmarcory_abidjan.jpeg",
    "jardin_botanique.jpeg",
    "noum_abidjan.jpeg",
    "pontado_abidjan.jpeg",
)

@Composable
fun Abidjan() {
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Toolbar(title = "Visit Côte d'Ivoire" )
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            IvoiryCoastCities()

        }
    }
}

@Composable
fun IvoiryCoastCities() {
    LazyColumn {
        item {
            Text(
                text = "Abidjan", modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 15.dp,),

                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 30.sp, shadow = Shadow(
                        color = Color.Green, blurRadius = 3f,
                    )
                )
            )

        }
        item {
            Text(
                text = "est la ville la plus peuplée de la Côte d'Ivoire." +
                        " Elle était la capitale administrative " +
                        "et politique du pays jusqu'en 1983," +
                        " date du transfert de jure de la capitale à Yamoussoukron 1. " +
                        "Elle est devenue," +
                        " depuis 2001, un « district autonome » " +
                        "de 2 119 km2 qui regroupe les dix communes " +
                        "de l'ancienne ville d'Abidjan" +
                        " (422 km2) et quatre sous-préfectures périphériques jadis rurales " +
                        "mais aujourd'hui gagnées par l'étalement urbain abidjanais"
            )
        }

    }
    Spacer(modifier = Modifier.padding(10.dp))

    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        itemsIndexed(abidjanImages) { index, imageName ->
            CoastCitiesItem(imageName = imageName)

        }

        }
    }

@Composable
fun CoastCitiesItem(imageName: String) {
    val imageResId = getImageResourceId(imageName)
    val painter: Painter = painterResource(id = imageResId)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .padding(4.dp)
    )
}
    
fun getImageResourceId(imageName: String) : Int {
    return when(imageName) {
        "boignypont_abidjan.jpeg" -> R.drawable.boignypont_abidjan
        "pyramide_abidjan.jpeg" -> R.drawable.pyramide_abidjan
        "nouveaupalais_abidjan.jpeg" -> R.drawable.nouveaupalais_abidjan
        "lestour_abidjan.jpeg" -> R.drawable.lestour_abidjan
        "page_abidjan.jpeg" -> R.drawable.page_abidjan
        "expositionparc_abidjan.jpeg" -> R.drawable.expositionparc_abidjan
        "echangeurnou_abidjan.jpeg" -> R.drawable.echangeurnou_abidjan
        "echandmarcory_abidjan.jpeg" -> R.drawable.echandmarcory_abidjan
        "hotelmarcory_abidjan.jpeg" -> R.drawable.hotelmarcory_abidjan
        "jardin_botanique.jpeg" -> R.drawable.jardin_botanique
        "noum_abidjan.jpeg" -> R.drawable.noum_abidjan
        "pontado_abidjan.jpeg" -> R.drawable.pontado_abidjan
        else -> R.drawable.noum_abidjan
    }
}


@Preview
@Composable
fun AbidjanPreview() {
    Abidjan()
}
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

val YamoussoukroImages = listOf(
    "basilique_bellevue.jpeg",
    "basilique_dore.jpeg",
    "basiliqueinter_yakro.jpeg",
    "caiman_capit.jpeg",
)

@Composable
fun Yamoussoukro() {
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
            YamoussoukroVille()


        }
    }
}
@Composable
fun YamoussoukroVille() {
    Text(text = "Yamoussoukro", modifier = Modifier
        .padding(horizontal = 5.dp, vertical = 5.dp,),

        fontWeight = FontWeight.Bold,
        style = TextStyle(
            fontSize = 30.sp, shadow = Shadow(
                color = Color.Green, blurRadius = 3f)
        )
    )
    Text(text = " devenue capitale politique de la Côte d'Ivoire en mars 1983," +
            " est le village natal du président Félix Houphouët-Boigny. " +
            "C'est la seule ville de la Côte d'Ivoire à avoir bénéficié " +
            "d'un plan d'urbanisme personnalisé, ce qui la différencie des autres." +
            " Son aménagement extensif se distingue par ses larges avenues, " +
            "souvent bordées de rangées d'arbres parfois doubles, de bas-côtés amples " +
            "et parfois engazonnés et plantés d'arbustes ornementaux, " +
            "et par ses nombreux espaces boisés d'essences variées," +
            " véritables « forêts urbaines » Yamoussoukro compte 372 559 habitants en 2021." +
            " Elle est la sixième ville la plus peuplée de Côte d'Ivoire " +
            "après Abidjan, Bouaké, Korhogo, Daloa et San-Pedro4.")
    Spacer(modifier = Modifier.height(10.dp))
    LazyColumn {
        items(YamoussoukroImages) { imageName ->
            MyImageItem(imageName = imageName)
        }

        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "meteo")
            }
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
fun MyImageItem(imageName: String) {
    val resId = getYamoussoukroResourceId(imageName)

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

fun getYamoussoukroResourceId(imageName: String): Int {
    return when (imageName) {
        "basilique_bellevue.jpeg" -> R.drawable.basilique_bellevue
        "basilique_dore.jpeg" -> R.drawable.basilique_dore
        "basiliqueinter_yakro.jpeg" -> R.drawable.basiliqueinter_yakro
        "caiman_capit.jpeg" -> R.drawable.caiman_capit
        else -> R.drawable.basilique_dore

    }

}


@Preview
@Composable
fun YamoussoukroPreview() {
    Yamoussoukro()
}
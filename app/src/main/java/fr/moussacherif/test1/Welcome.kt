package fr.moussacherif.test1



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
val cities = listOf(
    "Abidjan",
    "Bouake",
    "Korhogo",
    "San Pedro",
    "Yamoussoukro",
    "Assinie")
 val iamgeNames = listOf(
       "abidjan_labelle.jpeg",
       "cite_balneaire.jpeg",
       "assinie_tour.jpeg",
       "plateauvue_aerienne.jpeg",
       "piscine_naturellesp.jpeg",
       "pont_lianesouest.jpeg",
       "masque_zaouli.jpeg"
   )
@Composable
fun Welcome(navController: NavHostController) {
    Surface (
        color = Color.White
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Toolbar(title = "Visit Côte d'Ivoire",navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.height(20.dp))
            ImageList(navController = navController)
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
@Composable
fun Toolbar(title: String, navController: NavHostController) {
    val menuItems =
        listOf("Histoire","Geographie","Economie","Sociologie","Politique","Sport","Culture")
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(

    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFFa500))
                .padding(10.dp)
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(color = Color.Green, blurRadius = 3f)
                ),
                modifier = Modifier
                // ajoute un padding a droite
            )
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Filled.Menu, "Menu")

        }
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        menuItems.forEach { menuItem ->
           DropdownMenuItem(text = { /*TODO*/ }, onClick =
           { // naviguer vers la page correspont au menuitem selectionné
               navController.navigate(menuItem)
               expanded = false })
               Text( menuItem, modifier = Modifier
                   .clickable {  }, style = TextStyle(fontSize = 20.sp)
                   )
           }
        }

    }
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        text,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {newText -> text = newText}
    )
    // Placeholder = { Text("Search")}
}

@Composable
fun ImageList(navController: NavHostController) {
    LazyColumn {
        items(iamgeNames) { imageName ->
           ImageListItemClickable(imageName)     }

        item {
            Text(
                text = "The most important cities of Cote d'ivoire", modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 15.dp, ),

                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 30.sp, shadow = Shadow(
                        color = Color.Green,  blurRadius = 3f,
                        )
                        )
                    )
        }

        items(cities) {
            city ->
            Text(
                text = city,
                Modifier
                    .padding(15.dp)
                    .clickable {

                        // Action à effectuer lorsque la ville est cliquée
                        // Par exemple, vous pouvez naviguer vers une autre page
                        navController.navigate(city) // Utilisez navController pour naviguere

                    }, fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 25.sp, shadow = Shadow(

                    )
                )
            )
        }
    }
}
@Composable
fun ImageListItemClickable (imageName: String) {
    val resId = getResourceId(imageName)

    Box (modifier = Modifier
        .padding(vertical = 20.dp)
        .clickable { }

    ){
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(400.dp)
                .absolutePadding(10.dp)
                .background(Green)
                .fillMaxSize()
                .height(200.dp)
        )
    }
}
fun getResourceId(imageName: String): Int {
    return when (imageName) {
        "abidjan_labelle.jpeg" -> R.drawable.abidjan_labelle
        "cite_balneaire.jpeg" -> R.drawable.cite_balneaire
        "assinie_tour.jpeg" -> R.drawable.assinie_tour
        "plateauvue_aerienne.jpeg" -> R.drawable.plateauvue_aerienne
        "piscine_naturellesp.jpeg" -> R.drawable.piscine_naturellesp
        "pont_lianesouest.jpeg" -> R.drawable.pont_lianesouest
        "masque_zaouli.jpeg" -> R.drawable.masque_zaouli

        else -> R.drawable.basilique_dore
    }
}
@Preview
@Composable
fun WelcomePreview() {
    val navController = rememberNavController()
    Welcome(navController)
}





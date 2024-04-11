package fr.moussacherif.test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.moussacherif.test1.ui.theme.Test1Theme


enum class Destination {
    welcome,Abidjan, Bouake, Korhogo, SanPedro, Yamoussoukro, Assinie

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                      Text(text = "Toolbar(title = \"Visit Côte d'Ivoire\")" )
                    })

                    { innerPadding ->
                        AppNavHost()
                    }

                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Destination.welcome.name) {
        composable(Destination.welcome.name) {
            Welcome(navController)
        }
        composable(Destination.Abidjan.name) {
            Abidjan()
        }
        composable(Destination.Bouake.name) {
            Bouake()

        }
        composable(Destination.Korhogo.name) {
            Korhogo()
        }
        composable(Destination.SanPedro.name) {
            SanPedro()
        }
        composable(Destination.Yamoussoukro.name) {
            Yamoussoukro()
        }
        composable(Destination.Assinie.name) {
            Assinie()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test1Theme {
        AppNavHost()
    }
}
package paulmassias.isis.appcv

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.windowsizeclass.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import paulmassias.isis.appcv.ui.theme.AppCVTheme
import java.util.function.ToIntFunction

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCVTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val viewModel = MainViewModel()
                    val windowSizeClass = calculateWindowSizeClass(this)
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    // Définition de la TopBar et appel de la BottomBar
                    Scaffold(
                        bottomBar = {
                            if (currentRoute != "profile") {
                                BottomNavigationBar(navController = navController)
                            }
                        },
                        topBar = {
                            if (currentRoute != "profile") {
                                TopAppBar(title = { Text("Cin'API") })
                            }
                        },
                        content = {
                            NavigationHost(
                                navController = navController,
                                viewModel = viewModel,
                                windowSizeClass = windowSizeClass
                            )
                        }

                    )
                }
            }
        }
    }
}

// Création du controller de navigation
@Composable
fun NavigationHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    windowSizeClass: WindowSizeClass
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    //Définition des "routes" de l'application qui dirigeront vers les différents écrans via les fonctions-écrans
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") { profil(windowSizeClass, navController) }
        composable("films") { FilmsVue(windowSizeClass, navController, viewModel) }
        composable("listeSerie") { SeriesVue(windowSizeClass, navController, viewModel) }
        composable("listePersonnes") { PersonnesVue(viewModel, navController) }
        composable(
            "filmDetail/{id}", // Routes paticulières a argument
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        {
            FilmDetailVue(navController, viewModel, navBackStackEntry?.arguments?.getInt("id"))
        }
        composable(
            "serieDetail/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        {

            SerieDetailVue(navController, viewModel, navBackStackEntry?.arguments?.getInt("id"))

        }
        composable(
            "personneDetail/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        {

            PersonDetailVue(navController, viewModel, navBackStackEntry?.arguments?.getInt("id"))

        }
    }
}


//Création de la BottomBar de navigation
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        //On utilise les NavBarItems de classe BarItem pour définir les icônes de navigation
        NavBarItems.BarItems.forEach { navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = { //Routage des icônes
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                },

                icon = {// Image de l'icône
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title
                    )
                },

                label = {// Text de l'icône
                    Text(text = navItem.title)
                },
            )

        }
    }
}







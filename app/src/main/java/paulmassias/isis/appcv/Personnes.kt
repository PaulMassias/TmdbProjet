package paulmassias.isis.appcv

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

//Fonction-écran affichant les acteurs en tendances
@Composable
fun PersonnesVue(viewModel: MainViewModel, navController: NavController) {

    val personneslist by viewModel.personnes.collectAsState()

    if (personneslist.isEmpty()) {
        viewModel.getPersonnes()// Méthode du viewModel qui récupére les données des acteurs
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier =
                Modifier
                    .padding(10.dp)
                    .padding(bottom = 40.dp)
            )
            {
                items(personneslist) { personne ->
                    Card(// Cartes clickables par acteurss, redirigeant vers le détail de l'acteur via le navController
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .clickable { navController.navigate("personneDetail/" + personne.id) },
                        elevation = 10.dp,
                        backgroundColor = Color.LightGray
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            AsyncImage( //Image de l'acteur suivie de son nom
                                model = "https://image.tmdb.org/t/p/w300" + personne.profile_path,
                                contentDescription = "Miniature de l'acteur"
                            )
                            Text(text = personne.name)
                        }
                    }
                }
            }
        }
    }
}


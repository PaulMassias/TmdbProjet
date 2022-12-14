package paulmassias.isis.appcv

import android.text.Layout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import org.intellij.lang.annotations.JdkConstants

//Fonction-écran affichant les séries en tendances
@Composable
fun SeriesVue(
    windowClass: WindowSizeClass,
    navController: NavController,
    viewModel: MainViewModel
) {

    val series by viewModel.series.collectAsState()

    if (series.isEmpty()) {
        viewModel.getSeries()// Méthode du viewModel qui récupére les données des séries
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier =
            Modifier
                .padding(10.dp)
                .padding(bottom = 40.dp)
        )
        {
            items(series) { serie ->
                Card( // Cartes clickables par séries, redirigeant vers le détail de la série via le navController
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable { navController.navigate("serieDetail/" + serie.id) },
                    elevation = 10.dp,
                    backgroundColor = Color.LightGray
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(// Image de la série suivie du nom et de la date de première diffusion
                            model = "https://image.tmdb.org/t/p/w300/" + serie.backdrop_path,
                            contentDescription = "Miniature du film"
                        )
                        Text(text = serie.name)
                        Text(text = serie.first_air_date)
                    }
                }
            }
        }
    }

}
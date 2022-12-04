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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.intellij.lang.annotations.JdkConstants


//Fonction-écran affichant le détail d'une série particulière
@Composable
fun SerieDetailVue(navController: NavController, viewModel: MainViewModel, id: Int?) {

    val serie by viewModel.serieForDetail.collectAsState()

    if (serie.id == 0) {
        viewModel.getSerieDetail(id) // Méthode du viewModel qui récupére les données de la série
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            // Retour a la page précédente via l'appel du navController
            Button(onClick = { navController.popBackStack("listeSerie", inclusive = false) }) {
                Text(text = "Retour")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(// Nom de la série
                    text = serie.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center
                )
                Text(// Première diffusion de la série
                    text = serie.first_air_date,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(//Poster de la serie
                    model = "https://image.tmdb.org/t/p/original" + serie.poster_path,
                    contentDescription = "Poster de la série"
                )
                Card(backgroundColor = Color.LightGray) {
                    Text(//Synopsis de la série
                        modifier = Modifier.padding(all = 10.dp),
                        text = serie.overview,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}


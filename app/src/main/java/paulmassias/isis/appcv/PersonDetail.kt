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

//Fonction-écran affichant le détail d'un acteur particulier
@Composable
fun PersonDetailVue(navController: NavController, viewModel: MainViewModel, id: Int?) {

    val person by viewModel.personForDetail.collectAsState()

    if (person.id == 0) {
        viewModel.getPersonDetail(id) // Méthode du viewModel qui récupére les données de l'acteur
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            // Retour a la page précédente via l'appel du navController
            Button(onClick = { navController.popBackStack("listePersonnes", inclusive = false) }) {
                Text(text = "Retour")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(// Nom de l'acteur
                    text = person.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center
                )
                Text(// Date de naissance de l'acteur
                    text = person.birthday,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(// Image de profil de l'acteur
                    model = "https://image.tmdb.org/t/p/original" + person.profile_path,
                    contentDescription = "Poster de l'acteur"
                )
                if (person.biography != "") { // Si la biographie existe, on l'affiche
                    Card(backgroundColor = Color.LightGray) {
                        Text(
                            modifier = Modifier.padding(all = 10.dp),
                            text = person.biography,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}


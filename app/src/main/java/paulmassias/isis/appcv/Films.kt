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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.intellij.lang.annotations.JdkConstants
import java.util.function.ToIntFunction


@Composable
fun FilmsVue(windowClass:WindowSizeClass, navController: NavController, viewModel: MainViewModel){

    val movies by viewModel.movies.collectAsState()

    if (movies.isEmpty()){
        viewModel.getMovies()
    }
    else {
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
                    items(movies) { movie ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .clickable { navController.navigate("filmDetail/" + movie.id) },
                            elevation = 10.dp,
                            backgroundColor = Color.LightGray,

                            ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                AsyncImage(
                                    model = "https://image.tmdb.org/t/p/w300/" + movie.backdrop_path,
                                    contentDescription = "Miniature du film"
                                )
                                Text(text = movie.original_title)
                                Text(text = movie.release_date)
                            }
                        }
                    }
                }
            }
        }
    }




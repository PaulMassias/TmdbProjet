package paulmassias.isis.appcv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Création de la class MainViewModel
class MainViewModel : ViewModel() {
    val api_key = "7207dd94649f08047a55ef9572aa3129"
    val langage = "fr"

    //Interface retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    //Variables dynamiques observés accueillant les résultats des requêtes
    val service = retrofit.create(API_TMDB::class.java)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbSerie>>(listOf())
    val personnes = MutableStateFlow<List<TmdbPerson>>(listOf())
    val movieForDetail = MutableStateFlow<TmdbMovie>(TmdbMovie())
    val serieForDetail = MutableStateFlow<TmdbSerie>(TmdbSerie())
    val personForDetail = MutableStateFlow<TmdbPerson>(TmdbPerson())

    //Appel de la requête via API_TMDB -> récupére les films en tendances
    fun getMovies() {
        viewModelScope.launch {
            movies.value = service.lastmovies(api_key).results
        }
    }

    //Appel de la requête via API_TMDB -> récupére les séries en tendances
    fun getSeries() {
        viewModelScope.launch {
            series.value = service.getseries(api_key).results
        }
    }

    //Appel de la requête via API_TMDB -> récupére les acteurs en tendances
    fun getPersonnes() {
        viewModelScope.launch {
            personnes.value = service.getpersonnes(api_key).results
        }
    }

    //Appel de la requête via API_TMDB -> récupére les détails d'un films
    fun getMovieDetail(movieId: Int?) {
        viewModelScope.launch {
            movieForDetail.value = service.detailmovies(movieId, langage, api_key)
        }
    }

    //Appel de la requête via API_TMDB -> récupére les détails d'une série
    fun getSerieDetail(tvId: Int?) {
        viewModelScope.launch {
            serieForDetail.value = service.detailseries(tvId, langage, api_key)
        }
    }

    //Appel de la requête via API_TMDB -> récupére les détails d'un Acteur
    fun getPersonDetail(personId: Int?) {
        viewModelScope.launch {
            personForDetail.value = service.detailperson(personId, langage, api_key)
        }
    }

}
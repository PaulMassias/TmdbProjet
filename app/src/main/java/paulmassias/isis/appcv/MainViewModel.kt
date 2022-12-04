package paulmassias.isis.appcv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val api_key="7207dd94649f08047a55ef9572aa3129"
    val langage="fr"

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val service = retrofit.create(API_TMDB::class.java)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbSerie>>(listOf())
    val personnes = MutableStateFlow<List<TmdbPerson>>(listOf())
    val movieForDetail = MutableStateFlow<TmdbMovie>(TmdbMovie())


    fun getMovies() {
        viewModelScope.launch {
            movies.value = service.lastmovies(api_key).results
        }
    }

    fun getSeries(){
        viewModelScope.launch {
            series.value = service.getseries(api_key).results
        }
    }

    fun getPersonnes(){
        viewModelScope.launch{
            personnes.value = service.getpersonnes(api_key).results
        }
    }

    fun getMoviesSearch(search : String){
        viewModelScope.launch{
            movies.value = service.searchmovies(api_key,search).results
        }
    }


    fun getMovieDetail(movieId : Int?){
        viewModelScope.launch{
            movieForDetail.value = service.detailmovies(movieId,langage,api_key)
        }
    }



}
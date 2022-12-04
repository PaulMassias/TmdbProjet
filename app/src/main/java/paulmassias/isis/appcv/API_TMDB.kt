package paulmassias.isis.appcv

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API_TMDB {

    //Récupére les données des films en tendances
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    //Récupére les données des séries en tendances
    @GET("trending/tv/week")
    suspend fun getseries(@Query("api_key") api_key: String): TmdbSerieResult

    //Récupére les données des acteurs en tendances
    @GET("trending/person/day")
    suspend fun getpersonnes(@Query("api_key") api_key: String): TmdbPersonResult

    //Récupére les données d'un film selon son Id
    @GET("movie/{movie_id}")
    suspend fun detailmovies(
        @Path("movie_id") id: Int?,
        @Query("language") langage: String,
        @Query("api_key") api_key: String
    ): TmdbMovie


    //Récupére les données d'une série selon son Id
    @GET("tv/{tv_id}")
    suspend fun detailseries(
        @Path("tv_id") id: Int?,
        @Query("language") langage: String,
        @Query("api_key") api_key: String
    ): TmdbSerie


    //Récupére les données d'un acteur selon son Id
    @GET("person/{person_id}")
    suspend fun detailperson(
        @Path("person_id") id: Int?,
        @Query("language") langage: String,
        @Query("api_key") api_key: String
    ): TmdbPerson

}

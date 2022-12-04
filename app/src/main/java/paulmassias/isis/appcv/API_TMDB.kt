package paulmassias.isis.appcv

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API_TMDB {


    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("trending/tv/week")
    suspend fun getseries(@Query("api_key") api_key: String): TmdbSerieResult

    @GET("trending/person/day")
    suspend fun getpersonnes(@Query("api_key") api_key: String): TmdbPersonResult

    @GET("search/movie")
    suspend fun searchmovies(@Query("api_key") api_key: String,
                             @Query("query") searchtext: String): TmdbMovieResult

    @GET("movie/{movie_id}")
    suspend fun detailmovies(@Path("movie_id") id: Int?,
                             @Query("language") langage: String,
                             @Query("api_key") api_key: String): TmdbMovie

    @GET("tv/{tv_id}")
    suspend fun detailseries(@Path("tv_id") id: Int?,
                             @Query("language") langage: String,
                             @Query("api_key") api_key: String): TmdbSerie


    @GET("person/{person_id}")
    suspend fun detailperson(@Path("person_id") id: Int?,
                             @Query("language") langage: String,
                             @Query("api_key") api_key: String): TmdbPerson

}

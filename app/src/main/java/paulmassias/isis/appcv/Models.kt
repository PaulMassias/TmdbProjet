package paulmassias.isis.appcv

class TmdbMovieResult(
    var page: Int = 0,
    val results: List<TmdbMovie> = listOf())

class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: Int = 0,
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "")

class TmdbSerieResult(
    var page: Int = 0,
    val results: List<TmdbSerie> = listOf())

class TmdbSerie(
    var overview: String = "",
    val first_air_date: String = "",
    val id: String = "",
    val name: String = "",
    val original_name: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "")


class TmdbPersonResult(
    val page: Int,
    val results: List<TmdbPerson>,
    val total_pages: Int,
    val total_results: Int)

class TmdbPerson(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)

 class KnownFor(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)




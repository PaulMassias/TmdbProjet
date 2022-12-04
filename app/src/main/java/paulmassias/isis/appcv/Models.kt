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
    val id: Int = 0,
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
    val adult: Boolean = false,
    val gender: Int = 0,
    val id: Int = 0,
    val known_for: List<KnownFor> = listOf(),
    val known_for_department: String = "",
    val media_type: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String ="",
    val birthday: String ="",
    val biography: String ="",
)

 class KnownFor(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int =0 ,
    val media_type: String ="",
    val original_language: String ="",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)




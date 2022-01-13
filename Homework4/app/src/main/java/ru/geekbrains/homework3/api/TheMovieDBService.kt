package ru.geekbrains.homework3.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.geekbrains.homework3.model.MovieDetails

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/popular?api_key=331893660bce350b2b8bc21cea28b6cf
    //https://api.themoviedb.org/3/movie/634649?api_key=331893660bce350b2b8bc21cea28b6cf
    //https://api.themoviedb.org/3/movie

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}
package ru.geekbrains.homework3.model

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.geekbrains.homework3.api.TheMovieDBService
import ru.geekbrains.homework3.viewmodel.AppState

class RepositoryImpl(private val apiService: TheMovieDBService) : Repository {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    override fun fetchSingleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }

    override fun getMovieDetailsAppState(): LiveData<AppState> {
        return movieDetailsNetworkDataSource.appState
    }
}
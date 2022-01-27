package ru.geekbrains.homework3.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.homework3.api.TheMovieDBService
import ru.geekbrains.homework3.viewmodel.AppState

class MovieDetailsNetworkDataSource(
    private val apiService: TheMovieDBService,
    private val compositeDisposable: CompositeDisposable
) {
    //LiveData immutable by nature but if we want to change it we should use MutableLiveData
    private val _appState = MutableLiveData<AppState>()
    val appState: LiveData<AppState>
        get() = _appState

    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieDetailsResponse: LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int) {
        _appState.postValue(AppState.Loading)

        try {
            compositeDisposable.add(
                apiService.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io()) //Schedulers.io() is a thread pool with network calls
                    .subscribe(
                        //if success we get movieDetails
                        {
                            _downloadedMovieDetailsResponse.postValue(it)
                            _appState.postValue(AppState.Success(it))
                        },
                        {
                            _appState.postValue(AppState.Error(it))
                            it.message?.let { it1 -> Log.e("MovieDetailsNetworkDataSource", it1) }
                        }
                    )
            )
        } catch (e: Exception) {
            e.message?.let { it1 -> Log.e("MovieDetailsNetworkDataSource", it1) }
        }
    }
}
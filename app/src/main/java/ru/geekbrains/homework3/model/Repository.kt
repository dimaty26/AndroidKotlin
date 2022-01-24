package ru.geekbrains.homework3.model

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.geekbrains.homework3.viewmodel.AppState

interface Repository {
    fun fetchSingleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails>

    fun getMovieDetailsAppState(): LiveData<AppState>
}
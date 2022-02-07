package ru.geekbrains.homework3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.geekbrains.homework3.model.MovieDetails
import ru.geekbrains.homework3.model.Repository

class MainViewModel(private val repository: Repository, movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        repository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val appState: LiveData<AppState> by lazy {
        repository.getMovieDetailsAppState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose() //avoid data leaks
    }
}
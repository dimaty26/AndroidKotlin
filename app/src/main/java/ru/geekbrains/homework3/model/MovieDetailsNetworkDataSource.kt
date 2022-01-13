package ru.geekbrains.homework3.model

import io.reactivex.disposables.CompositeDisposable
import ru.geekbrains.homework3.api.TheMovieDBService

class MovieDetailsNetworkDataSource(
    private val apiService: TheMovieDBService,
    private val compositeDisposable: CompositeDisposable
) {

}
package ru.geekbrains.homework3.viewmodel

import ru.geekbrains.homework3.model.MovieDetails

sealed class AppState {
    object Loading : AppState()
    data class Success(val movieResponse: MovieDetails) : AppState()
    data class Error(val error: Throwable) : AppState()
}
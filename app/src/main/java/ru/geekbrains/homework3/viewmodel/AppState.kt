package ru.geekbrains.homework3.viewmodel

import ru.geekbrains.homework3.model.Movie

sealed class AppState {
    object Loading : AppState()
    data class Success(val movieResponse: Movie) : AppState()
    data class Error(val error: Throwable) : AppState()
}
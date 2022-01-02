package ru.geekbrains.homework2

sealed class AppState {
    data class Loading(var progres: Int) : AppState()
    data class Success(var response: String) : AppState()
    data class Error(var error: Throwable) : AppState()
}
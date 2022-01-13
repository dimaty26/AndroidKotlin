package ru.geekbrains.homework3.model

class RepositoryImpl : Repository {

    override fun getMovieFromServer(): Movie {
        return getDefaultMovie()
    }

    override fun getMovieFromLocalStorage(): Movie {
        return getDefaultMovie()
    }
}
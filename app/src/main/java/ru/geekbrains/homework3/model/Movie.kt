package ru.geekbrains.homework3.model

data class Movie(
    val name: String,
    val type: String,
    val description: String,
    val year: Int,
    val length: Int,
    val rating: Double
)

fun getDefaultMovie() = Movie(
    DefaultMovie.name,
    DefaultMovie.type,
    DefaultMovie.description,
    DefaultMovie.year,
    DefaultMovie.length,
    DefaultMovie.rating
)

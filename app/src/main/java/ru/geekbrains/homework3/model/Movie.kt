package ru.geekbrains.homework3.model

data class Movie(
    val name: String,
    val type: String,
    val description: String,
    val year: Int,
    val length: Int,
    val rating: Double
)

fun getDefaultMovies() = listOf(
    Movie(
        "Spider-Man: No Way Home",
        "comics",
        "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero.",
        2021,
        155,
        8.7
    ),
    Movie(
        "Eternals",
        "comics",
        "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years.",
        2021,
        143,
        6.9
    ),
    Movie(
        "Encanto",
        "cartoon",
        "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto.",
        2021,
        132,
        8.6
    ),
    Movie(
        "Resident Evil: Welcome to Raccoon City",
        "thriller",
        "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town.",
        2021,
        144,
        6.9
    )
)

package ru.geekbrains.homework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.geekbrains.homework3.api.POSTER_BASE_URL
import ru.geekbrains.homework3.api.TheMovieDBClient
import ru.geekbrains.homework3.api.TheMovieDBService
import ru.geekbrains.homework3.databinding.FragmentMainBinding
import ru.geekbrains.homework3.model.MovieDetails
import ru.geekbrains.homework3.model.Repository
import ru.geekbrains.homework3.model.RepositoryImpl
import ru.geekbrains.homework3.viewmodel.AppState
import ru.geekbrains.homework3.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService: TheMovieDBService = TheMovieDBClient.getClient()
        repository = RepositoryImpl(apiService)

        viewModel = getViewModel(1) //id = 1 is example
        viewModel.movieDetails.observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.appState.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = if (it == AppState.Loading) View.VISIBLE else View.GONE
            binding.txtError.visibility =
                if (it == AppState.Error(Throwable())) View.VISIBLE else View.GONE
        })
    }

    private fun getViewModel(movieId: Int): MainViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository, movieId) as T
            }
        })[MainViewModel::class.java]
    }

    private fun renderData(movie: MovieDetails) {
        setData(movie)
    }

    private fun setData(movie: MovieDetails) {
        binding.movieName.text = movie.title
        binding.description.text = movie.overview
        binding.year.text = movie.releaseDate
        binding.movieLength.text = movie.runtime.toString() + " minutes"
        binding.ratings.text = movie.rating.toString()

        val moviePosterURL = POSTER_BASE_URL + movie.posterPath
        Glide.with(this).load(moviePosterURL).into(binding.moviePoster)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
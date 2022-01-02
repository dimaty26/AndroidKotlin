package ru.geekbrains.homework3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.geekbrains.homework3.AppState
import ru.geekbrains.homework3.MainViewModel
import ru.geekbrains.homework3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer<AppState> { renderData(it) })
        viewModel.getDataFromServer()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                val data = appState.response
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView, data, Snackbar.LENGTH_LONG).show()
            }
            is AppState.Error -> {
                val data = appState.error.message
                binding.loadingLayout.visibility = View.GONE
                if (data != null) {
                    Snackbar
                        .make(binding.mainView, data, Snackbar.LENGTH_INDEFINITE)
                        .setAction("Reload") { viewModel.getDataFromServer() }
                        .show()
                }
            }
        }
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
package ru.geekbrains.homework3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.homework3.model.Repository
import ru.geekbrains.homework3.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveData

    fun getMovieFromLocalSource() = getDataFromServer()

    fun getDataFromServer() {
        Thread {
            sleep(5000)
            liveData.postValue(AppState.Success(repositoryImpl.getMovieFromLocalStorage()))
        }.start()
    }
}
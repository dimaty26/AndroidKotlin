package ru.geekbrains.homework2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep
import java.util.*

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val random: Random = Random(),
    private var list: List<AppState> = arrayListOf(
        AppState.Success("OK"),
        AppState.Loading(50), AppState.Error(Exception("Just Error"))
    )
) : ViewModel() {

    fun getLiveData(): LiveData<AppState> {
        return liveData
    }

    fun getDataFromServer() {
        Thread {
            sleep(5000)
            liveData.postValue(list[random.nextInt(3)])
        }.start()
    }
}
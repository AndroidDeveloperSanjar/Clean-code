package uz.androbeck.cleancode.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.androbeck.cleancode.network.response.PrayerTimesResponse

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _prayerTimes = MutableLiveData<Response<ArrayList<PrayerTimesResponse>>>()
    val prayerTimes: LiveData<Response<ArrayList<PrayerTimesResponse>>> = _prayerTimes

    fun data(
        latitude: Double,
        longitude: Double,
        method: Int,
        month: Int,
        year: Int,
        school: Int
    ) = viewModelScope.launch {
        _prayerTimes.value = repository.data(latitude, longitude, method, month, year, school)
    }
}
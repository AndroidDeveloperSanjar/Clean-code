package uz.androbeck.cleancode.ui.main

import uz.androbeck.cleancode.network.Api
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: Api
) {
    suspend fun data(
        latitude: Double,
        longitude: Double,
        method: Int,
        month: Int,
        year: Int,
        school: Int
    ) = api.getPrayerTimes(latitude, longitude, method, month, year, school)
}
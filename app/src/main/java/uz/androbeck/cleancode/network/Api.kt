package uz.androbeck.cleancode.network

import retrofit2.http.GET
import retrofit2.http.Query
import uz.androbeck.cleancode.network.response.PrayerTimesResponse

interface Api {
    @GET("namaz?")
    suspend fun getPrayerTimes(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Int,
        @Query("month") month: Int,
        @Query("year") year: Int,
        @Query("school") school: Int,
    ): retrofit2.Response<ArrayList<PrayerTimesResponse>>
}
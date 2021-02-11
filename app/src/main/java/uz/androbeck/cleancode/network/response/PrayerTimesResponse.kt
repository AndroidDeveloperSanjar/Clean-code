package uz.androbeck.cleancode.network.response

data class PrayerTimesResponse(
    val Asr: String,
    val Dhuhr: String,
    val Fajr: String,
    val Isha: String,
    val Maghrib: String,
    val Sunrise: String,
    val gregorian: String,
    val hijri: String,
    val weekday: String
)

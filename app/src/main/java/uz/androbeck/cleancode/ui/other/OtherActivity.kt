package uz.androbeck.cleancode.ui.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.androbeck.cleancode.R

@AndroidEntryPoint
class OtherActivity : AppCompatActivity() {

    private val viewModel by viewModels<OtherViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        viewModel.data(41.3505923, 69.2194397, 2, 2, 2021, 1)

        viewModel.prayerTimes.observe(this, { response ->
            if (response.isSuccessful) {
                println("Data came!")
                val dataList = response.body()
                println(dataList)
            }
        })
    }
}
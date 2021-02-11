package uz.androbeck.cleancode.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import uz.androbeck.cleancode.R
import uz.androbeck.cleancode.network.Api
import uz.androbeck.cleancode.ui.other.OtherActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var tvData: TextView

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvData = findViewById(R.id.tv_data)


        viewModel.data(41.3505923, 69.2194397, 2, 2, 2021, 1)

        viewModel.prayerTimes.observe(this, { response ->
            if (response.isSuccessful) {
                println("Data came!")
                val dataList = response.body()
                println(dataList)
            }
        })

        tvData.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }
    }
}
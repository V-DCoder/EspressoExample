package com.varun.espressoexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.varun.espressoexample.models.ForeCastResponse
import com.varun.espressoexample.models.NetworkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitBtn.setOnClickListener {
            tv.text = editText.text
        }

        openBtn.setOnClickListener { loadData() }
    }

    private fun loadData() {

        NetworkManager().loadData().subscribe({
            onSuccess(it)
        }, { it.printStackTrace() })
    }

    private fun onSuccess(it: ForeCastResponse?) {
        Log.w("response",it?.forecast?.forecastday?.get(0)?.day?.maxtempC.toString())
    }
}

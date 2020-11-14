package com.i.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var myLifecycleObserver: MyLifecycleObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLifecycleObserver = MyLifecycleObserver(this, lifecycle)
        myLifecycleObserver.locationData.observe(this, Observer { location ->
            latitude.text = location.latitude.toString()
            longitude.text = location.longitude.toString()
        })
    }
}
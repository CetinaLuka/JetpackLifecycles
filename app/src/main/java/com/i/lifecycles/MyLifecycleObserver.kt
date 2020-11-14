package com.i.lifecycles

import LocationRepository
import android.content.Context
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifecycleObserver(private val context: Context, private val lifecycle: Lifecycle): LifecycleObserver{
    val locationData = LocationRepository(context)
    init { lifecycle.addObserver(this) }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startLocationUpdates(){
        locationData.startUpdates()
        Log.i("lifecycle", "start")
        Toast.makeText(context, "Started location updates", Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopLocationUpdates(){
        locationData.stopUpdates()
        Log.i("lifecycle", "stop")
        Toast.makeText(context, "Stopped location updates", Toast.LENGTH_SHORT).show()
    }
}
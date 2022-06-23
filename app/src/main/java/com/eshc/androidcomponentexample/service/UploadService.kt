package com.eshc.androidcomponentexample.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.lifecycle.MutableLiveData

class UploadService : Service() {

    private val binder = MyBinder()

    private val stateLiveData = MutableLiveData<String>().apply {
        this.value = "Uploading Start!!"
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate() {
        super.onCreate()
        Handler().postDelayed({
            stateLiveData.value = "Done!!"
        }, 1000)
    }

    inner class MyBinder : Binder() {
        val service: UploadService
            get() = this@UploadService
    }

    fun getState() = stateLiveData
}
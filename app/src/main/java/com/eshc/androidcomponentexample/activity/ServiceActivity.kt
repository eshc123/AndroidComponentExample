package com.eshc.androidcomponentexample.activity

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eshc.androidcomponentexample.R
import com.eshc.androidcomponentexample.databinding.ActivityServiceBinding
import com.eshc.androidcomponentexample.service.RingtoneService
import com.eshc.androidcomponentexample.service.UploadService

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityServiceBinding

    private lateinit var mService : UploadService
    private var mBound : Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as UploadService.MyBinder
            mService = binder.service
            mBound = true

            mService.getState().observe(this@ServiceActivity, Observer {
                Toast.makeText(this@ServiceActivity, it.toString(), Toast.LENGTH_SHORT).show()
            })
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_service)

        binding.btStartService.setOnClickListener {
            startRingtoneService()
        }
        binding.btBindingService.setOnClickListener {
            startUploadService()
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }
    private fun startRingtoneService(){
        startService(Intent(this, RingtoneService::class.java))
    }
    private fun startUploadService(){
        Intent(this,UploadService::class.java).run{
            bindService(this, connection, Service.BIND_AUTO_CREATE)
        }

    }
}
package com.eshc.androidcomponentexample.activity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eshc.androidcomponentexample.R
import com.eshc.androidcomponentexample.broadcastreceiver.TimeCheckBroadcastReceiver
import com.eshc.androidcomponentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btService.setOnClickListener {
            goToServiceActivity()
        }
        setBroadcastReceiver()
    }

    private fun goToServiceActivity(){
        startActivity(Intent(this, ServiceActivity::class.java))
    }
    private fun setBroadcastReceiver(){
        val intent = IntentFilter(Intent.ACTION_TIME_TICK)
        val receiver = TimeCheckBroadcastReceiver()
        registerReceiver(receiver,intent)
    }
}
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
        binding.btBroadcastReceiver.setOnClickListener {
            goToBroadcastReceiverActivity()
        }

    }

    private fun goToServiceActivity(){
        startActivity(Intent(this, ServiceActivity::class.java))
    }
    private fun goToBroadcastReceiverActivity(){
        startActivity(Intent(this, BroadcastReceiverActivity::class.java))
    }

}
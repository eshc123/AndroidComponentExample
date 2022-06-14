package com.eshc.androidcomponentexample.activity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.eshc.androidcomponentexample.R
import com.eshc.androidcomponentexample.broadcastreceiver.TimeCheckBroadcastReceiver
import com.eshc.androidcomponentexample.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity() {

    var receiver: TimeCheckBroadcastReceiver? = null
    lateinit var binding : ActivityBroadcastReceiverBinding
    var isRegistered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_broadcast_receiver)

        binding.btRegisterReceiver.setOnClickListener {
            setBroadcastReceiver()
        }
        binding.btUnregisterReceiver.setOnClickListener {
            cancelBroadcastReceiver()
        }
    }
    private fun setBroadcastReceiver(){
        val intent = IntentFilter(Intent.ACTION_TIME_TICK)
        receiver = TimeCheckBroadcastReceiver()
        registerReceiver(receiver,intent)
        isRegistered = true

    }
    private fun cancelBroadcastReceiver(){
        if(receiver != null && isRegistered){
            unregisterReceiver(receiver)
            isRegistered = false
        } else {
            Toast.makeText(this,"Broadcast Receiver have not been registered",Toast.LENGTH_SHORT).show()
        }
    }
}
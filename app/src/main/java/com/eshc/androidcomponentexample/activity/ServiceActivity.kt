package com.eshc.androidcomponentexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eshc.androidcomponentexample.R
import com.eshc.androidcomponentexample.databinding.ActivityServiceBinding
import com.eshc.androidcomponentexample.service.RingtoneService

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_service)

        binding.btStartService.setOnClickListener {
            startRingtoneService()
        }
    }
    private fun startRingtoneService(){
        startService(Intent(this, RingtoneService::class.java))
    }
}
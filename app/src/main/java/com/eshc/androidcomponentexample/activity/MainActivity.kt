package com.eshc.androidcomponentexample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eshc.androidcomponentexample.R
import com.eshc.androidcomponentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btService.setOnClickListener {
            goToServiceActivity()
        }
    }

    private fun goToServiceActivity(){
        startActivity(Intent(this, ServiceActivity::class.java))
    }
}
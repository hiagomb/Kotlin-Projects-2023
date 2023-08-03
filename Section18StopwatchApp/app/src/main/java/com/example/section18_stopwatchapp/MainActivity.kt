package com.example.section18_stopwatchapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.section18_stopwatchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var isStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener(this)
        binding.btnStop.setOnClickListener(this)
        serviceIntent = Intent(this, StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATED_TIME))
    }


    private fun startOrStop(){
        if(isStarted){
            stop()
        }else{
            start()
        }
    }

    private fun start(){
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME, time)
        startService(serviceIntent)
        binding.btnStart.setText("Stop")
        isStarted = true
    }

    private fun stop(){
        stopService(serviceIntent)
        binding.btnStart.setText("Start")
        isStarted = false
    }

    private fun reset(){
        stop()
        time = 0.0
        binding.tvTime.text = getFormatedTime(time)
    }

    private val updateTime : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(StopWatchService.CURRENT_TIME, 0.0)
            binding.tvTime.text = getFormatedTime(time)
        }
    }


    private fun getFormatedTime(time: Double): String{
        val timeInt = time.toInt()
        val hours = timeInt % 86400 / 3600
        val minutes = timeInt % 86400 / 60
        val seconds = timeInt % 86400 % 3600 % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btnStart){
            startOrStop()
        }else if(v.id == R.id.btnStop){
            reset()
        }
    }



}
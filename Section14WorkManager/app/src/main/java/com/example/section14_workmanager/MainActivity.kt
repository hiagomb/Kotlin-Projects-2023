package com.example.section14_workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOneTimeWorkRequest()
    }


    private fun setOneTimeWorkRequest(){

        val constrains = Constraints.Builder().setRequiresCharging(true).build()
        val data = Data.Builder().putInt("index", 125).build()

        val workRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setConstraints(constrains).setInputData(data).build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(workRequest)
        workManager.getWorkInfoByIdLiveData(workRequest.id).observe(this){
            Log.i("MyTAG", "Observing: ${it.state.name}")
            if(it.state.isFinished){
                val result = it.outputData.getString("output")
                Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show()
            }
        }
    }

}
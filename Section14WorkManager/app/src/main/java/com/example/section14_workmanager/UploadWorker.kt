package com.example.section14_workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        try{
            val index = inputData.getInt("index", 0)
            for(i in 0..index){
                Log.i("MyTAG", "uploading $i image")
            }
            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outputData = Data.Builder().putString("output", currentDate).build()
            return Result.success(outputData)
        }catch(e: Exception){
            return Result.failure()
        }

    }





}
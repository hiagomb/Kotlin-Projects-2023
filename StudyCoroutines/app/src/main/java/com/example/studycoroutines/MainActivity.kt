package com.example.studycoroutines

//References: https://www.youtube.com/watch?v=F63mhZk-1-Y
/* Coroutines:

First Step -> add the dependencies

-----------------------------------------------
suspend fun -> can be used in coroutines (I can just call a suspend function from a coroutine or
another suspend function)

delay <> Thread.sleep -> delay works just for the single current coroutine, whereas Thread.sleep
works for the whole thread (all coroutines inside the thread). Just use delay inside a coroutine.

withContext() -> switchs the context of the Coroutine

Dispatcher -> context where I will launch our coroutine
    Dispatchers:
        - IO: network requests
        - Default: heavy computation
        - Main: UI thread
        - Unconfined: ?
        - newSingleThreadContext("myThread")
Scope -> interface that provides the management of the execution of the coroutines

*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.studycoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val job = GlobalScope.launch(Dispatchers.IO) { // GlobalScope means this
            // coroutine will live as long as the application does -> it is not recommended
            val result1 = fakeApiRequest1()
            val result2 = fakeApiRequest2()
            Log.d(TAG, result1)
            Log.d(TAG, result2)
            //both results will come after 6 seconds -> 3000 + 3000

            withContext(Dispatchers.Main){ //I can just manipulate UI components from Main Context (UI thread)
                binding.textView.text = result1
            }
        }



//        runBlocking { // this function blocks the UI thread whereas launch does not
//            //job.join() // it will block the thread until our coroutine finished
//            job.cancel() // cancel the job
//        }

        lifecycleScope.launch(Dispatchers.IO){
            //this scope is linked to the current activity
            //if the activity is destroyed, the coroutines in this scope are destroyed too
            //viewmodelScope is the same
        }

        //ref: https://kotlinlang.org/docs/coroutines-guide.html

        //doubts: scope -> https://medium.com/mobile-app-development-publication/kotlin-coroutine-scope-context-and-job-made-simple-5adf89fcfe94


    }


    private suspend fun fakeApiRequest1(): String{
        delay(3000)
        return "Result fakeApiRequest 1"
    }

    private suspend fun fakeApiRequest2(): String{
        delay(3000)
        return "Result fakeApiRequest 2"
    }
}



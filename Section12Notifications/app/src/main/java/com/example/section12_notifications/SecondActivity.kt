package com.example.section12_notifications

import android.app.Notification
import android.app.RemoteInput
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat

class SecondActivity : AppCompatActivity() {


    private val CHANNEL_ID = "MINE"
    private val NOTIFICATION_ID = 1
    private val KEY_REPLY = "replay"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getReply()
    }


    private fun getReply(){
        val intent = intent
        val response = RemoteInput.getResultsFromIntent(intent)?.getString(KEY_REPLY)

        val repliedNotification = Notification.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Your answer: $response")
            .build()

        NotificationManagerCompat.from(this).apply {
            notify(NOTIFICATION_ID, repliedNotification)
        }
    }
}
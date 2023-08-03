package com.example.section12_notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "MINE"
    private val NOTIFICATION_ID = 1
    private val KEY_REPLY = "replay"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        setNotification()
    }

    private fun setNotification(){

//        val intent = Intent(this, SecondActivity::class.java)
//        val pendindIntent = PendingIntent.getActivity(this, 0, intent,
//            PendingIntent.FLAG_IMMUTABLE)

        val dismissIntent = Intent(this, SecondActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(this, 0, dismissIntent,
//            PendingIntent.FLAG_IMMUTABLE)


        //reply button
        val remoteInput = androidx.core.app.RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert your name here")
            build()
        }
        val pendingReplyintent = PendingIntent.getActivity(this, 0, dismissIntent,
            PendingIntent.FLAG_MUTABLE)

        val replyAction = NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground,
        "Reply here", pendingReplyintent).addRemoteInput(remoteInput).build()


        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Titulo da Notificação")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Corpo da Notificação")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            //.setContentIntent(pendindIntent)
            .addAction(replyAction)

        with(NotificationManagerCompat.from(this)){
            notify(NOTIFICATION_ID, builder.build())
        }
    }


    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Hiago Channel"
            val descriptionText = "Channel description of my app"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }
}
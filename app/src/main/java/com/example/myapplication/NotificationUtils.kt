package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

lateinit var notificationChannel:NotificationChannel
lateinit var notificationManager: NotificationManager
lateinit var builder: NotificationCompat.Builder

fun Context.showNotification(channelId: String, title: String, body: String){

    // É responsavel por gerenciar todas as notificações responsaveis pelo aplicativo
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    var intent = Intent(this, MainActivity::class.java)
    var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        notificationChannel = NotificationChannel(channelId, body, NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.BLUE
            enableVibration(true)
        }

        notificationManager.createNotificationChannel(notificationChannel)
        builder = NotificationCompat.Builder(this, channelId).apply {
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setContentTitle(title)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    }
    notificationManager.notify(channelId.toInt(), builder.build())
}
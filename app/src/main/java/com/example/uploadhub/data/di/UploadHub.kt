package com.example.uploadhub.data.di

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.uploadhub.data.worker.ImageWorker
import dagger.hilt.android.HiltAndroidApp


class UploadHub : Application(), Configuration.Provider {
    private lateinit var customWorkerFactory: CustomWorkerFactory
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(customWorkerFactory).build()

    companion object {
        const val CHANNEL_ID = "image_upload_channel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotification()
    }

    private fun createNotification() {
        val name = "Image Upload"
        val descriptionText = "Notification for images uploaded"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

class CustomWorkerFactory :
    WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            ImageWorker::class.java.name -> ImageWorker(appContext, workerParameters)
            else -> null
        }
    }
}

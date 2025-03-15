package com.example.uploadhub.data.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ImageWorker(appContext: Context, workParams: WorkerParameters) :
    Worker(appContext, workParams) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}
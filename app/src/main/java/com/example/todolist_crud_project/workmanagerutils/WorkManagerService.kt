package com.example.todolist_crud_project.workmanagerutils

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

class WorkManagerService(val context: Context) {

    fun schedule(name: String, delay: Long){
        val constraints = Constraints.Builder()

            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)

            val request = OneTimeWorkRequestBuilder<NotificationWorker>()
                .addTag(name)
                .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                // .setConstraints(constraints)
                .setInputData(workDataOf("name" to name)).build()

        WorkManager.getInstance(context).enqueue(request)
    }
}
package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker2(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("RRR","Worker 2 started!")
        val keyA = inputData.getString("keyA")
        val keyB = inputData.getInt("keyB",0)
        Thread.sleep(3000)
        Log.d("RRR","Worker 2: data from Worker 1: $keyA $keyB")
        return Result.success()
    }
}
package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("RRR", "MyWorker 1 started!")
        Thread.sleep(3000)
        val data = Data.Builder().putString("keyA", "hello").putInt("keyB",1).build()
        return Result.success(data)
    }
}
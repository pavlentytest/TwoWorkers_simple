package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val worker1 = OneTimeWorkRequestBuilder<MyWorker>().build()
        val worker2 = OneTimeWorkRequestBuilder<MyWorker2>().build()
        button.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .build()

            val myWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<MyWorker>()
                    .setConstraints(constraints)
                    .build()
            WorkManager.getInstance(this).enqueue(myWorkRequest)

            // последовательно
            WorkManager.getInstance(this)
                .beginWith(worker1)
                .then(worker2)
                .enqueue()
            // параллельно
           // WorkManager.getInstance(this).enqueue(worker1, worker2)
        }

    }
}
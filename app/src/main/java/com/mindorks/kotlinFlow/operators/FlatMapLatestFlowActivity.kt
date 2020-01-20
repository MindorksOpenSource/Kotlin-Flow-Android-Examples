package com.mindorks.kotlinFlow.operators

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.kotlinFlow.R
import kotlinx.android.synthetic.main.activity_example.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


class FlatMapLatestFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        setupClick()
    }

    private fun setupClick() {
        btn.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
                lifecycleScope.launchWhenCreated  {
            val output =
                flow {
                    emit("Himanshu")
                    delay(100)
                    emit("Amit")
                    delay(100)
                    emit("Janishar")
                }.flatMapLatest { name ->
                    flow {
                        delay(200)
                        emit("$name Ali")
                    }
                }.toList()
            textView.text = output.toString()

        }
    }


}
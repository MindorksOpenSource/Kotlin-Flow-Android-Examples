package com.mindorks.kotlinFlow.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.kotlinFlow.R
import kotlinx.android.synthetic.main.activity_example.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class SimpleFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        setupFlow()
        setupClick()
    }

    private fun setupClick() {
        btn.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        lifecycleScope.launchWhenCreated {
            val output = flowOf(1, 2, 3).toList()
            textView.text = output.toString()
        }
    }

    private fun setupFlow() {


    }
}
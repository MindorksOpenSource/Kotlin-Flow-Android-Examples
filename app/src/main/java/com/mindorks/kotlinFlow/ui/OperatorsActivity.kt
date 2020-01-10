package com.mindorks.kotlinFlow.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.kotlinFlow.R
import com.mindorks.kotlinFlow.ui.operators.*

class OperatorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)
    }

    fun startSimpleActivity(view: View?) {}
    fun startContextActivity(view: View?) {}
    fun startZipActivity(view: View?) = startActivity(Intent(this, ZipFlowActivity::class.java))


    fun startDelayActivity(view: View?) {}
    fun startDistinctActivity(view: View?) {}
    fun startEmitterActivity(view: View?) {}
    fun startErrorsActivity(view: View?) {}
    fun startLimitActivity(view: View?) {}
    fun startTransformActivity(view: View?) {}
    fun startFlatMapConcatActivity(view: View) =
        startActivity(Intent(this, FlatMapConcatFlowActivity::class.java))

    fun startFlatMapMergeActivity(view: View) =
        startActivity(Intent(this, FlatMapMergeFlowActivity::class.java))

    fun startFlattenConcatFlowActivity(view: View) =
        startActivity(Intent(this, FlattenConcatFlowActivity::class.java))

    fun startMergeFlowActivity(view: View) =
        startActivity(Intent(this, MergeFlowActivity::class.java))

    fun startFlatterMergeFlowActivity(view: View) =
        startActivity(Intent(this, FlattenMergeFlowActivity::class.java))

    fun startTransformLatestFlowActivity(view: View) =
        startActivity(Intent(this, TransformLatestFlowActivity::class.java))

    fun startFlatMapLatestFlowActivity(view: View)  =
        startActivity(Intent(this, FlatMapLatestFlowActivity::class.java))
}
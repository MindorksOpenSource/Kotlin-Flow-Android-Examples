package com.mindorks.kotlinFlow

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.kotlinFlow.learn.completion.CompletionActivity
import com.mindorks.kotlinFlow.learn.errorhandling.catch.CatchActivity
import com.mindorks.kotlinFlow.learn.errorhandling.emitall.EmitAllActivity
import com.mindorks.kotlinFlow.learn.filter.FilterActivity
import com.mindorks.kotlinFlow.learn.map.MapActivity
import com.mindorks.kotlinFlow.learn.reduce.ReduceActivity
import com.mindorks.kotlinFlow.learn.retrofit.parallel.ParallelNetworkCallsActivity
import com.mindorks.kotlinFlow.learn.retrofit.series.SeriesNetworkCallsActivity
import com.mindorks.kotlinFlow.learn.retrofit.single.SingleNetworkCallActivity
import com.mindorks.kotlinFlow.learn.retry.RetryActivity
import com.mindorks.kotlinFlow.learn.retryexponentialbackoff.RetryExponentialBackoffActivity
import com.mindorks.kotlinFlow.learn.retrywhen.RetryWhenActivity
import com.mindorks.kotlinFlow.learn.room.RoomDBActivity
import com.mindorks.kotlinFlow.learn.search.SearchActivity
import com.mindorks.kotlinFlow.learn.task.onetask.LongRunningTaskActivity
import com.mindorks.kotlinFlow.learn.task.twotasks.TwoLongRunningTasksActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSingleNetworkCallActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleNetworkCallActivity::class.java))
    }

    fun startSeriesNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, SeriesNetworkCallsActivity::class.java))
    }

    fun startParallelNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, ParallelNetworkCallsActivity::class.java))
    }

    fun startRoomDatabaseActivity(view: View) {
        startActivity(Intent(this@MainActivity, RoomDBActivity::class.java))
    }

    fun startCatchActivity(view: View) {
        startActivity(Intent(this@MainActivity, CatchActivity::class.java))
    }

    fun startEmitAllActivity(view: View) {
        startActivity(Intent(this@MainActivity, EmitAllActivity::class.java))
    }

    fun startCompletionActivity(view: View) {
        startActivity(Intent(this@MainActivity, CompletionActivity::class.java))
    }

    fun startLongRunningTaskActivity(view: View) {
        startActivity(Intent(this@MainActivity, LongRunningTaskActivity::class.java))
    }

    fun startTwoLongRunningTasksActivity(view: View) {
        startActivity(Intent(this@MainActivity, TwoLongRunningTasksActivity::class.java))
    }

    fun startFilterActivity(view: View) {
        startActivity(Intent(this@MainActivity, FilterActivity::class.java))
    }

    fun startMapActivity(view: View) {
        startActivity(Intent(this@MainActivity, MapActivity::class.java))
    }

    fun startReduceActivity(view: View) {
        startActivity(Intent(this@MainActivity, ReduceActivity::class.java))
    }

    fun startSearchActivity(view: View) {
        startActivity(Intent(this@MainActivity, SearchActivity::class.java))
    }

    fun startRetryActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryActivity::class.java))
    }

    fun startRetryWhenActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryWhenActivity::class.java))
    }

    fun startRetryExponentialBackoffActivity(view: View) {
        startActivity(Intent(this@MainActivity, RetryExponentialBackoffActivity::class.java))
    }

}

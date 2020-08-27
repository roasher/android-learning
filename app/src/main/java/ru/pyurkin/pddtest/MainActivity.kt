package ru.pyurkin.pddtest

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    init {
        Log.i("main", "Main Activity constructor initialized")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("main", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.i("main", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("main", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("main", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("main", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("main", "onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("main", "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }
}
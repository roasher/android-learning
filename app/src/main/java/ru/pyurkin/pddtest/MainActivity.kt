package ru.pyurkin.pddtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.pyurkin.pddtest.screens.launcher.MainFragment

class MainActivity : AppCompatActivity() {

    init {
        Log.i("main", "Main Activity constructor initialized")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("main", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
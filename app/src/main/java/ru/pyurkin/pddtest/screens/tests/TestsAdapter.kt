package ru.pyurkin.pddtest.screens.tests

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestsAdapter: RecyclerView.Adapter<TestsAdapter.TestViewHolder>() {
    class TestViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        Log.i("TestAdapter", "onBindViewHolder position:${position}")
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

package ru.pyurkin.pddtest.screens.tests

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ru.pyurkin.pddtest.R

class TestsAdapter : RecyclerView.Adapter<TestsAdapter.TestViewHolder>() {

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val models: MutableList<TestModel> = ArrayList()

    fun setModel(model: List<TestModel>) {
        this.models.clear()
        this.models.addAll(model)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TestViewHolder(inflater.inflate(R.layout.item_test, parent, false))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        Log.i("TestAdapter", "onBindViewHolder position:${position}")
        val (name, isChecked, icon) = models[position]
        val itemView = holder.itemView
        if (icon > 0) {
            itemView.findViewById<AppCompatImageView>(R.id.test_icon).setImageResource(icon)
        }
        itemView.findViewById<AppCompatTextView>(R.id.test_text).text = name
        val checkBox = itemView.findViewById<AppCompatCheckBox>(R.id.test_check_box)
        checkBox.isChecked = isChecked

        checkBox.setOnClickListener {
            models[position].isChecked = checkBox.isChecked
        }
    }

    override fun getItemCount(): Int = this.models.size
}

data class TestModel(val name: String, var isChecked: Boolean, val icon: Int)
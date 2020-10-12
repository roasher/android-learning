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
import kotlin.collections.ArrayList

interface OnCheckBoxClick {
    fun doOnCheckBoxClick(model: TestsAdapter.TestModel, checkBox: AppCompatCheckBox)
}

class TestsAdapter(private val onCheckBoxClick: OnCheckBoxClick?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract class Model {
        abstract fun getItemViewType(): Int
    }
    data class TestModel(val name: String, var isChecked: Boolean, val icon: Int) : Model() {
        override fun getItemViewType(): Int {
            return 0
        }
    }

    data class BannerModel(val icon: Int) : Model() {
        override fun getItemViewType(): Int {
            return 1
        }
    }

    @Suppress("UNCHECKED_CAST")
    interface Bindable<T:Model> {
        fun bindModel(model: Model) {
            val tempModel = model as? T
                ?: throw IllegalArgumentException("Invalid type ${model.javaClass.name} passed to this parser")
            bind(tempModel)
        }
        fun bind(model: T)
    }

    class TestViewHolder(itemView: View, val onCheckBoxClick: OnCheckBoxClick?) : RecyclerView.ViewHolder(itemView), Bindable<TestModel> {
        override fun bind(model: TestModel) {
            if (model.icon > 0) {
                itemView.findViewById<AppCompatImageView>(R.id.test_icon).setImageResource(model.icon)
            }
            itemView.findViewById<AppCompatTextView>(R.id.test_text).text = model.name
            val checkBox = itemView.findViewById<AppCompatCheckBox>(R.id.test_check_box)
            checkBox.isChecked = model.isChecked

            checkBox.setOnClickListener {
                onCheckBoxClick?.doOnCheckBoxClick(model, checkBox)
            }
        }
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<BannerModel> {
        override fun bind(model: BannerModel) {
            itemView.findViewById<AppCompatImageView>(R.id.item_banner).setImageResource(model.icon)
        }
    }

    private val model: MutableList<Model> = ArrayList()

    fun setModel(model: List<Model>) {
        this.model.clear()
        this.model.addAll(model)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.i("TestsAdapter", "onCreateViewHolder viewType:${viewType}")
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> TestViewHolder(inflater.inflate(R.layout.item_test, parent, false), onCheckBoxClick)
            1 -> BannerViewHolder(inflater.inflate(R.layout.item_banner, parent, false))
            else -> throw IllegalArgumentException("Unknown View Holder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i("TestAdapter", "onBindViewHolder position:${position}")
        if (holder is Bindable<*>) {
            holder.bindModel(model[position])
        }
    }

    override fun getItemCount(): Int = this.model.size

    override fun getItemViewType(position: Int): Int {
        return model[position].getItemViewType()
    }
}
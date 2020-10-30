package ru.pyurkin.pddtest.screens.tests

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.pyurkin.pddtest.R

class TestsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<TestsAdapter.Model>>()
    var items: LiveData<List<TestsAdapter.Model>> = _items;

    init {
        val generatedData = generateData()
        _items.postValue(generatedData)

        Handler().postDelayed({
            Log.i(this.javaClass.toString(),"data changed!!!")
            for (model: TestsAdapter.Model in _items.value.orEmpty()) {
                model.icon = R.mipmap.img_logo
            }
            _items.postValue(_items.value)
        }, 5000)
    }

    private fun generateData(): List<TestsAdapter.Model> {
        val model = ArrayList<TestsAdapter.Model>()
        for (i in 0..20) {
            model.add(TestsAdapter.TestModel("simple name${i}", false, R.mipmap.ic_launcher))
        }
        model.set(4, TestsAdapter.BannerModel(R.mipmap.ic_launcher))
        model.set(7, TestsAdapter.BannerModel(R.mipmap.img_logo))
        return model
    }

}
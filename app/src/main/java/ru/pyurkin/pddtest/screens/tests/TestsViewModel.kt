package ru.pyurkin.pddtest.screens.tests

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.pyurkin.pddtest.R
import ru.pyurkin.pddtest.data.products.ProductRepository
import javax.inject.Inject

class TestsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _items = MutableLiveData<List<TestsAdapter.Model>>()
    var items: LiveData<List<TestsAdapter.Model>> = _items;

    val errors = MutableLiveData<String>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun generateData() {
        compositeDisposable.addAll(
            productRepository.fetchProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ products ->
                    val model = ArrayList<TestsAdapter.Model>()
                    for (product in products) {
                        model.add(
                            TestsAdapter.TestModel(
                                product.title,
                                false,
                                R.mipmap.ic_launcher
                            )
                        )
                        _items.postValue(model)
                    }
                }, {
                    errors.postValue(it.toString())
                })
        );

        Handler().postDelayed({
            Log.i(this.javaClass.toString(), "data changed!!!")
            for (model: TestsAdapter.Model in _items.value.orEmpty()) {
                model.icon = R.mipmap.img_logo
            }
            _items.postValue(_items.value)
        }, 5000)
    }

}
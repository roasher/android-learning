package ru.pyurkin.pddtest.data.products.local

import io.reactivex.Completable
import ru.pyurkin.pddtest.data.products.Product

class SharedPrefsDataSource: ProductLocalDataSource {
    override fun saveRemote(data: List<Product>): Completable {
        TODO("Not yet implemented")
    }

    override fun fetchLocal(): List<Product> {
        return emptyList()
    }
}
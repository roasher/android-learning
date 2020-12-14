package ru.pyurkin.pddtest.data.products.local

import io.reactivex.Completable
import io.reactivex.Single
import ru.pyurkin.pddtest.data.products.Product

interface ProductLocalDataSource {
    fun saveRemote(data: List<Product>): Completable
    fun fetchLocal(): List<Product>
}
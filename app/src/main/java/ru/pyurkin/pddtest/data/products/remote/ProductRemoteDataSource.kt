package ru.pyurkin.pddtest.data.products.remote

import io.reactivex.Single
import ru.pyurkin.pddtest.data.products.Product

interface ProductRemoteDataSource {
    fun fetchRemote(): Single<List<Product>>
}
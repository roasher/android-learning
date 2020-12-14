package ru.pyurkin.pddtest.data.products

import io.reactivex.Single
import ru.pyurkin.pddtest.data.products.local.ProductLocalDataSource
import ru.pyurkin.pddtest.data.products.remote.ProductRemoteDataSource
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val localDataSource: ProductLocalDataSource,
    private val remoteDataSource: ProductRemoteDataSource
){
    fun fetchProducts(): Single<List<Product>> {
        return remoteDataSource.fetchRemote().flatMap {
            localDataSource.saveRemote(it)
            Single.just(it)
        }
    }
}
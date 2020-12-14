package ru.pyurkin.pddtest.data.products.remote

import io.reactivex.Single
import ru.pyurkin.pddtest.data.products.Product
import ru.pyurkin.pddtest.data.products.ProductsApi
import javax.inject.Inject

class RetrofitProductsDataSource @Inject constructor(val productsApi: ProductsApi) :
    ProductRemoteDataSource {
    override fun fetchRemote(): Single<List<Product>> {
        return productsApi.get();
    }
}
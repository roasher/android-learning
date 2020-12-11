package ru.pyurkin.pddtest.data.products

import io.reactivex.Single
import retrofit2.http.GET

interface ProductsApi {

    companion object {
        val baseUrl = "https://fakestoreapi.com";
    }

    @GET("/products")
    fun get(): Single<List<Product>>

}
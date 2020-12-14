package ru.pyurkin.pddtest.di.module

import dagger.Module
import dagger.Provides
import ru.pyurkin.pddtest.data.products.ProductRepository
import ru.pyurkin.pddtest.data.products.local.ProductLocalDataSource
import ru.pyurkin.pddtest.data.products.remote.ProductRemoteDataSource

@Module
class RepositoryModule {

    @Provides
    fun provideProductRepository(
        localDataSource: ProductLocalDataSource,
        remoteDataSource: ProductRemoteDataSource
    ): ProductRepository {
        return ProductRepository(localDataSource, remoteDataSource)
    }
}
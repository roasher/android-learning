package ru.pyurkin.pddtest.screens

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.pyurkin.pddtest.data.products.ProductsApi
import ru.pyurkin.pddtest.di.AppComponent
import javax.inject.Inject

class PddTestApplication : Application() {
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>
//
//    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        setUpRetrofit()

        appComponent = DaggerAppComponent
            .builder()
            .build()
//        appComponent.inject(this)

    }
}
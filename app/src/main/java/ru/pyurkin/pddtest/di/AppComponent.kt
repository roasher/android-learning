package ru.pyurkin.pddtest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.pyurkin.pddtest.di.module.RemoteModule
import ru.pyurkin.pddtest.di.module.RepositoryModule
import ru.pyurkin.pddtest.di.module.ViewModelModule
import ru.pyurkin.pddtest.screens.PddTestApplication
import ru.pyurkin.pddtest.screens.tests.TestsFragment
import ru.pyurkin.pddtest.screens.tests.TestsModule
import javax.inject.Singleton

@Component(
    modules = [
        RemoteModule::class,
        TestsModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<PddTestApplication> {

    fun inject(testsFragment: TestsFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
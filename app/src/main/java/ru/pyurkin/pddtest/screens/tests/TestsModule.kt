package ru.pyurkin.pddtest.screens.tests

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.pyurkin.pddtest.helpers.ViewModelKey

@Module
abstract class TestsModule {

    @Binds
    @IntoMap
    @ViewModelKey(TestsViewModel::class)
    internal abstract fun questPageViewModel(viewModel: TestsViewModel): ViewModel
}
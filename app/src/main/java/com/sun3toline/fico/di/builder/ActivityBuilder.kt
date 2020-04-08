package com.sun3toline.fico.di.builder

import androidx.lifecycle.ViewModelProvider
import com.sun3toline.fico.di.factory.ViewModelFactory
import com.sun3toline.fico.di.module.MainModule
import com.sun3toline.fico.di.scope.Presentation
import com.sun3toline.fico.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeToMainActivity(): MainActivity
}
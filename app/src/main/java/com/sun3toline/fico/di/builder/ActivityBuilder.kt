package com.sun3toline.fico.di.builder

import com.sun3toline.fico.di.module.MainModule
import com.sun3toline.fico.di.scope.Presentation
import com.sun3toline.fico.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeToMainActivity(): MainActivity
}
package com.sun3toline.fico.di.component

import com.sun3toline.fico.App
import com.sun3toline.fico.di.builder.ActivityBuilder
import com.sun3toline.fico.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ActivityBuilder::class
    ]
)
interface ApplicationComponent : AndroidInjector<App>
package com.sun3toline.fico.di.module

import com.sun3toline.fico.data.network.CountryDataSource
import com.sun3toline.fico.presentation.MainActivity
import com.sun3toline.fico.presentation.MainViewModel
import com.sun3toline.fico.presentation.MainViewModelCallback
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class MainModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainDataSource(retrofit: Retrofit): CountryDataSource =
            retrofit.create(CountryDataSource::class.java)

        @JvmStatic
        @Provides
        fun provideMainViewModel(
            callback: MainViewModelCallback,
            dataSource: CountryDataSource
        ): MainViewModel = MainViewModel(callback, dataSource)
    }

    @Binds
    abstract fun bindMainViewModelCallback(activity: MainActivity): MainViewModelCallback
}
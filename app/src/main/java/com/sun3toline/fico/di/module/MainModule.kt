package com.sun3toline.fico.di.module

import androidx.lifecycle.ViewModel
import com.sun3toline.fico.data.network.CountryDataSource
import com.sun3toline.fico.di.scope.ViewModelKey
import com.sun3toline.fico.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class MainModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainDataSource(retrofit: Retrofit): CountryDataSource =
            retrofit.create(CountryDataSource::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
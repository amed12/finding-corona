package com.sun3toline.fico.di.module

import com.sun3toline.fico.data.network.CountryDataSource
import com.sun3toline.fico.presentation.HomePresenter
import com.sun3toline.fico.presentation.HomeViewContract
import com.sun3toline.fico.presentation.MainActivity
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
        fun providesMainPresenter(
            viewContract: HomeViewContract,
            dataSource: CountryDataSource
        ): HomePresenter = HomePresenter(viewContract, dataSource)
    }

    @Binds
    abstract fun bindMainView(activity: MainActivity): HomeViewContract
}
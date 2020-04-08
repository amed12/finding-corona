package com.sun3toline.fico.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.sun3toline.fico.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewContract by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tb_main)
        viewModel.states.observe(this, Observer { state ->
            when (state) {
                is MainViewState.loading -> pb_main.visibility = View.VISIBLE
                is MainViewState.Success -> {
                    pb_main.visibility = View.GONE
                    rv_country.addItemDecoration(
                        DividerItemDecoration(
                            this,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                    rv_country.hasFixedSize()
                    rv_country.adapter =
                        MainAdapter(state.response.countries.sortedByDescending { it.totalDeaths })
                }
                is MainViewState.Error -> {
                    pb_main.visibility = View.GONE
                    Toast.makeText(this, state.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.showTotalConfirmed()
    }
}

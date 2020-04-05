package com.sun3toline.fico.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.sun3toline.fico.R
import com.sun3toline.fico.data.network.models.CountryResponse
import com.sun3toline.fico.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainViewModelCallback {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            viewModel = this@MainActivity.viewModel
        }.also {
            viewModel.showTotalConfirmed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }

    override fun onSuccess(result: List<CountryResponse.Country>) {
        binding.rvCountry.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvCountry.hasFixedSize()
        binding.rvCountry.adapter = MainAdapter(result)

    }

    override fun onError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }
}

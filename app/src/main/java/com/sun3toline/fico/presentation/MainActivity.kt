package com.sun3toline.fico.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sun3toline.fico.R
import com.sun3toline.fico.data.network.models.CountryResponse
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HomeViewContract {
    private lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tb_main)
        presenter.showDeathFromAllCountry()
    }

    override fun onShowLoading() {
        pb_main?.visibility = View.VISIBLE
        rv_country?.visibility = View.GONE
    }

    override fun onHideLoading() {
        pb_main?.visibility = View.GONE
        rv_country?.visibility = View.VISIBLE
    }

    override fun onResponse(results: List<CountryResponse.Country>) {
        rv_country?.setHasFixedSize(true)
        val result = results.sortedWith(compareByDescending { it.totalDeaths })
        rv_country?.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mainAdapter = MainAdapter(result)
        rv_country?.adapter = mainAdapter
        rv_country?.layoutManager = LinearLayoutManager(this)
        mainAdapter.notifyDataSetChanged()
    }

    override fun onFailure(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}

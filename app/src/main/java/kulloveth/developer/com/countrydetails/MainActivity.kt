package kulloveth.developer.com.countrydetails

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kulloveth.developer.com.countrydetails.ui.MainAdapter
import kulloveth.developer.com.countrydetails.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryRv.layoutManager = StaggeredGridLayoutManager(2, requestedOrientation)
        countryRv.adapter = adapter

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.fetchCountrys().observe(this, Observer {
            it.forEach {
                Log.d("nnnn", "" + it.name)
            }
            adapter.submitList(it)
        })
    }
}

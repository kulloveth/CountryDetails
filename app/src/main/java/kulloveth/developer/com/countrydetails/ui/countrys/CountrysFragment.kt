package kulloveth.developer.com.countrydetails.ui.countrys


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_countrys.*

import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.ui.MainAdapter
import kulloveth.developer.com.countrydetails.ui.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class CountrysFragment : Fragment() {

    val adapter = MainAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countrys, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        countryRv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
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

package kulloveth.developer.com.countrydetails.ui.countrys


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_countrys.*
import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.ui.MainViewModelFactory


/**
 * A simple [Fragment] subclass.
 */
class CountrysFragment : Fragment() {

    val adapter = CountrysAdapter()
    var navController: NavController? = null
    private val viewModelFactory = MainViewModelFactory()
    private lateinit var viewModel: CountrysViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_countrys, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        countryRv.layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
        countryRv.adapter = adapter

        initViewModel()
        swipeToRefresh.setOnRefreshListener {
            viewModel.fetchCountrys().observe(requireActivity(), Observer {
                it.forEach {
                    Log.d("nnnn", "" + it.name)
                }
                adapter.submitList(it)
                swipeToRefresh.isRefreshing = false
            })

        }
    }

    private fun initViewModel() {

        activity.let {
            viewModel = ViewModelProvider(
                requireActivity(),
                viewModelFactory
            ).get(CountrysViewModel::class.java)
            viewModel.fetchCountrys().observe(requireActivity(), Observer {
                it.forEach {
                    Log.d("nnnn", "" + it.name)
                }
                adapter.submitList(it)
                swipeToRefresh.isRefreshing = false
            })

            adapter.setUpListener(object : CountrysAdapter.ItemCLickedListener {
                override fun onItemClicked(countryDetails: CountryDetails) {
                    val bundle = bundleOf(
                        "countryName" to countryDetails.name,
                        "countryFlag" to countryDetails.flag,
                        "timeZone" to countryDetails.timezones
                    )
                    viewModel.setTranslations(countryDetails.translations)
                    viewModel.setLanguages(countryDetails.language)
                    navController!!.navigate(
                        R.id.action_countrysFragment_to_detailsFragment,
                        bundle
                    )
                    Log.d("cor", "" + countryDetails.name)

                }

            })
        }

    }

}

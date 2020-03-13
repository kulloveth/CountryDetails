package kulloveth.developer.com.countrydetails.ui.details.languages


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_languages.*

import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel

/**
 * A simple [Fragment] subclass.
 */
class LanguagesFragment : Fragment() {

    val adapter = LanguageAdapter()
    val viewModel: CountrysViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_languages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = adapter

        activity.let {
            viewModel.languageLiveData.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })
        }
    }
}

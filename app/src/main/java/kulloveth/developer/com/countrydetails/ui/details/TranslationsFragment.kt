package kulloveth.developer.com.countrydetails.ui.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_translations.*

import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel

/**
 * A simple [Fragment] subclass.
 */
class TranslationsFragment : Fragment() {

    private val viewModel: CountrysViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.translationsLiveData.observe(viewLifecycleOwner, Observer {
            germanTrans.text = it.de
            spanishTrans.text = it.es
            frenchTrans.text = it.fr
            japanTrans.text = it.ja
            italianTrans.text = it.it
            persianTrans.text = it.fa

        })
    }
}

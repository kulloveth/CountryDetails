package kulloveth.developer.com.countrydetails.ui.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_translations.*
import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.databinding.FragmentTranslationsBinding
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class TranslationsFragment : Fragment() {

    private val viewModel: CountrysViewModel by sharedViewModel()
    private var binding:FragmentTranslationsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTranslationsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.translationsLiveData.observe(requireActivity(), Observer {
            binding?.germanTrans?.text = it.de
            binding?.spanishTrans?.text = it.es
            binding?.frenchTrans?.text = it.fr
            binding?.japanTrans?.text = it.ja
            binding?.italianTrans?.text = it.it
            binding?.persianTrans?.text = it.fa

        })
    }
}

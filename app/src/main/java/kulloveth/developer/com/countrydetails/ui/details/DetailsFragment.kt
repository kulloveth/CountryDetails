package kulloveth.developer.com.countrydetails.ui.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rv_list_item.*

import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysAdapter

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


    var countryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryId = arguments!!.getInt("countryId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryId.let {
           object :CountrysAdapter.ItemCLickedListener{
               override fun onItemClicked(countryDetails: CountryDetails) {
                   country.text = countryDetails.name
               }

           }
        }
    }


}

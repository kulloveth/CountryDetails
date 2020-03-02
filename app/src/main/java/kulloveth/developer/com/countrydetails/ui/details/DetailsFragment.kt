package kulloveth.developer.com.countrydetails.ui.details


import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahmadrosid.svgloader.SvgLoader
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.rv_list_item.*
import kotlinx.android.synthetic.main.rv_list_item.view.*

import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysAdapter
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


    var countryName: String? = null
    var countryFlag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryName = arguments!!.getString("countryName")
        countryFlag = arguments!!.getString("countryFlag")
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
        Log.d("corn",""+countryName)
        country_text.text=countryName
        SvgLoader.pluck()
            .with(context as Activity?)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(countryFlag, flag_img)

           object :CountrysAdapter.ItemCLickedListener{
               override fun onItemClicked(countryDetails: CountryDetails) {
                   val viewModel = ViewModelProvider(this@DetailsFragment).get(CountrysViewModel::class.java)




           }
        }
    }


}

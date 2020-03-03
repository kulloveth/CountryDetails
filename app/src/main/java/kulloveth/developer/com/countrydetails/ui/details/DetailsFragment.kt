package kulloveth.developer.com.countrydetails.ui.details


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ahmadrosid.svgloader.SvgLoader
import kotlinx.android.synthetic.main.fragment_details.*
import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


    var countryName: String? = null
    var countryFlag: String? = null
    val viewModel: CountrysViewModel by activityViewModels()

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
        Log.d("corn", "" + countryName)
        country_text.text = countryName
        viewModel.translationsLiveData.observe(viewLifecycleOwner, Observer {
            germanTrans.text = it.de
            spanishTrans.text = it.es
            frenchTrans.text = it.fr
            japanTrans.text = it.ja
            italianTrans.text = it.it
            persianTrans.text = it.fa

        })
        SvgLoader.pluck()
            .with(context as Activity?)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(countryFlag, flag_img)
    }


}

package kulloveth.developer.com.countrydetails.ui.details


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahmadrosid.svgloader.SvgLoader
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_details.*
import kulloveth.developer.com.countrydetails.R

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


    private lateinit var viewPagerAdapter: ViewPagerAdapter
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
        Log.d("corn", "" + countryName)

        country_text.text = countryName

        SvgLoader.pluck()
            .with(context as Activity?)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(countryFlag, flag_img)

        viewPagerAdapter = ViewPagerAdapter(this)
        pager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> tab.text = "Translation"
                1 -> tab.text = "Languages"
            }

        }.attach()
    }


}

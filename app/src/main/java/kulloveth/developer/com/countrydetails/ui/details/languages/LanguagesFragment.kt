package kulloveth.developer.com.countrydetails.ui.details.languages


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kulloveth.developer.com.countrydetails.R

/**
 * A simple [Fragment] subclass.
 */
class LanguagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_languages, container, false)
    }


}

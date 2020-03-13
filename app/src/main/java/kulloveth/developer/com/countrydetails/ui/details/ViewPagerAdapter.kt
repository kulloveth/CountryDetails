package kulloveth.developer.com.countrydetails.ui.details

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kulloveth.developer.com.countrydetails.ui.details.languages.LanguagesFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    val arrayList: ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {

        0 -> TranslationsFragment()
        1 -> LanguagesFragment()
        else -> throw IllegalStateException("Invalid adapter position")
    }




}



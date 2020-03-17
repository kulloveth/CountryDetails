package kulloveth.developer.com.countrydetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel

class MainViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return CountrysViewModel() as T
    }
}
package kulloveth.developer.com.countrydetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel() as T
    }
}
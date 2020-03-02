package kulloveth.developer.com.countrydetails.ui.countrys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.data.model.CountryDetails

class CountrysViewModel : ViewModel() {

    private var countrysLiveData = MutableLiveData<List<CountryDetails>>()


    fun fetchCountrys(): LiveData<List<CountryDetails>> {
        countrysLiveData = CountryDetailsRepository().countrysLiveData
        return countrysLiveData
    }
}
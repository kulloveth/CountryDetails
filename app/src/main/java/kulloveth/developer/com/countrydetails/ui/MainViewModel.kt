package kulloveth.developer.com.countrydetails.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.data.model.CountryDetails

class MainViewModel() : ViewModel() {

    private val countryLivedata: MutableLiveData<List<CountryDetails>> by lazy {
        MutableLiveData<List<CountryDetails>>().also {
            CountryDetailsRepository().fetchCountrys()
        }

    }

    fun fetchCountrys(): LiveData<List<CountryDetails>> {
        return countryLivedata
    }
}
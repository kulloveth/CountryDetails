package kulloveth.developer.com.countrydetails.ui.countrys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.data.model.Language
import kulloveth.developer.com.countrydetails.data.model.Translations

class CountrysViewModel : ViewModel() {

    private var countrysLiveData = MutableLiveData<List<CountryDetails>>()
    var translationsLiveData = MutableLiveData<Translations>()
    var languageLiveData = MutableLiveData<List<Language>>()

    fun fetchCountrys(): LiveData<List<CountryDetails>> {
        countrysLiveData = CountryDetailsRepository().countrysLiveData
        return countrysLiveData
    }

    fun setTranslations(translations: Translations) {
        translationsLiveData.value = translations
    }

    fun setLanguages(language: List<Language>) {
        languageLiveData.value = language
    }


}
package kulloveth.developer.com.countrydetails.ui.countrys

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.data.model.Language
import kulloveth.developer.com.countrydetails.data.model.Translations
import kulloveth.developer.com.countrydetails.utils.Progressive
import retrofit2.Response

class CountrysViewModel : ViewModel() {

    var disposable = CompositeDisposable()
    var translationsLiveData = MutableLiveData<Translations>()
    var languageLiveData = MutableLiveData<List<Language>>()

    var progressive: Progressive? = null

    val countrysLiveData: MutableLiveData<List<CountryDetails>> by lazy {
        MutableLiveData<List<CountryDetails>>().also {
            fetchCountrys()
        }
    }


    fun fetchCountrys() {
        progressive?.onStarted()
        CountryDetailsRepository().fetchCountryDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progressive?.onStarted() }
            .doOnSuccess {  progressive?.onSuccess() }
            .subscribe(object : SingleObserver<Response<List<CountryDetails>>> {
                override fun onSuccess(t: Response<List<CountryDetails>>) {

                    countrysLiveData.value = t.body()

                    Log.d("rest", "" + countrysLiveData)
                }

                override fun onSubscribe(d: Disposable) {
                  disposable.add(d)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { progressive?.onFailure(it) }
                }
            })
    }

    fun loadCountryDetails(): LiveData<List<CountryDetails>> {
        return countrysLiveData
    }

    fun setTranslations(translations: Translations) {
        translationsLiveData.value = translations
    }

    fun setLanguages(language: List<Language>) {
        languageLiveData.value = language
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}
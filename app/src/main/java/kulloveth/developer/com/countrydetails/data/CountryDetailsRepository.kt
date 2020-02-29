package kulloveth.developer.com.countrydetails.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kulloveth.developer.com.countrydetails.api.RetrofitService
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import retrofit2.Response

class CountryDetailsRepository {

    val countrysLiveData: MutableLiveData<List<CountryDetails>> by lazy {
        MutableLiveData<List<CountryDetails>>().also {
            fetchCountryDetails()
        }
    }

    fun fetchCountryDetails() {
        val api = RetrofitService.getRetrofitInstance().fetchCharacterName()
        api.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<List<CountryDetails>>> {
                override fun onSuccess(t: Response<List<CountryDetails>>) {
                 countrysLiveData.value = t.body()
                    Log.d("rest","" + countrysLiveData)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                }

            })
    }
}
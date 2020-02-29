package kulloveth.developer.com.countrydetails.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kulloveth.developer.com.countrydetails.api.RetrofitService
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import retrofit2.Response
import java.nio.charset.Charset

class MainViewModel: ViewModel() {

   private var countrysLiveData = MutableLiveData<List<CountryDetails>> ()


    fun fetchCountrys(): LiveData<List<CountryDetails>> {
        countrysLiveData = CountryDetailsRepository().countrysLiveData
        return countrysLiveData
    }
}
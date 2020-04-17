package kulloveth.developer.com.countrydetails.data

import io.reactivex.Single
import kulloveth.developer.com.countrydetails.api.RetrofitService
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import retrofit2.Response

class CountryDetailsRepository {


    fun fetchCountryDetails(): Single<Response<List<CountryDetails>>> {
        return RetrofitService.getRetrofitInstance().fetchCharacterName()
    }
}
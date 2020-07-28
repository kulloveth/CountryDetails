package kulloveth.developer.com.countrydetails.data

import io.reactivex.Single
import kulloveth.developer.com.countrydetails.api.RetrofitService
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import org.koin.dsl.module
import retrofit2.Response

class CountryDetailsRepository (private val retrofitService: RetrofitService) {


    fun fetchCountryDetails(): Single<Response<List<CountryDetails>>> {
        return retrofitService.fetchCharacterName()
    }
}
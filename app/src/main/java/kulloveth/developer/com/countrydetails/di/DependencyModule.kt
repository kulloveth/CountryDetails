package kulloveth.developer.com.countrydetails.di

import kulloveth.developer.com.countrydetails.api.RetrofitService
import kulloveth.developer.com.countrydetails.data.CountryDetailsRepository
import kulloveth.developer.com.countrydetails.ui.countrys.CountrysViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module{
    single(named("BASE_URL")){
        "https://restcountries.eu/"
    }
    single {
        Retrofit.Builder().baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(RetrofitService::class.java)
    }
}

val viewModelMocule = module {
    single {
        CountrysViewModel(get())
    }
}

val repositoryModule = module {
    factory {
        CountryDetailsRepository(get())
    }
}
package kulloveth.developer.com.countrydetails

import android.app.Application
import kulloveth.developer.com.countrydetails.di.networkModule
import kulloveth.developer.com.countrydetails.di.repositoryModule
import kulloveth.developer.com.countrydetails.di.viewModelMocule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(networkModule, viewModelMocule, repositoryModule))
        }
    }


}
package kulloveth.developer.com.countrydetails.utils

interface Progressive {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}
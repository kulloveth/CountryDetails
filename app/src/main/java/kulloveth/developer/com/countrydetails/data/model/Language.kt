package kulloveth.developer.com.countrydetails.data.model

import java.io.Serializable

data class Language(
    val iso6391: String,
    val iso6392: String,
    val nativeName: String
) : Serializable
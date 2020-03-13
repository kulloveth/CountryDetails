package kulloveth.developer.com.countrydetails.data.model

import java.io.Serializable

data class Language(
    val id: Int,
    val iso6391: String,
    val iso6392: String,
    val name: String,
    val nativeName: String
) : Serializable
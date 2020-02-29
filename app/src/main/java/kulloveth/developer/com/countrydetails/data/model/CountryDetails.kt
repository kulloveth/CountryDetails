package kulloveth.developer.com.countrydetails.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryDetails(
    @SerializedName("name")
    @Expose
    val name: String
) : Serializable
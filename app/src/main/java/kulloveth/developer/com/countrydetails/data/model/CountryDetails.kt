package kulloveth.developer.com.countrydetails.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryDetails(
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("flag")
    @Expose
    val flag: String,
    val timezones : ArrayList<String>,
    @SerializedName("translations")
    val translations: Translations,
    @SerializedName("languages")
    val language: List<Language>
) : Serializable
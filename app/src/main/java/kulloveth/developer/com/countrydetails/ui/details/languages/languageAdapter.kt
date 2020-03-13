package kulloveth.developer.com.countrydetails.ui.details.languages

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import kotlinx.android.synthetic.main.rv_list_item.view.*
import kulloveth.developer.com.countrydetails.R
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import kulloveth.developer.com.countrydetails.data.model.Language

class languageAdapter : ListAdapter<Language, languageAdapter.MainViewHolder>(
    DiffCallback()
) {


    class DiffCallback : DiffUtil.ItemCallback<Language>() {
        override fun areItemsTheSame(oldItem: Language, newItem: Language): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Language, newItem: Language): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item, parent, false)
        return MainViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))

    }


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(language: Language) {
            //itemView.country.text = countryDetails.name

        }


    }
}
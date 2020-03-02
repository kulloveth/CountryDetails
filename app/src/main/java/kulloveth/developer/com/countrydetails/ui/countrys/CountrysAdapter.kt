package kulloveth.developer.com.countrydetails.ui.countrys

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

class CountrysAdapter : ListAdapter<CountryDetails, CountrysAdapter.MainViewHolder>(
    DiffCallback()
) {

    lateinit var context: Context
    lateinit var mItemCLicked: ItemCLickedListener


    class DiffCallback : DiffUtil.ItemCallback<CountryDetails>() {
        override fun areItemsTheSame(oldItem: CountryDetails, newItem: CountryDetails): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CountryDetails, newItem: CountryDetails): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.rv_list_item, parent, false)
        return MainViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position), context)
        holder.itemView.setOnClickListener {
            mItemCLicked.let {
                mItemCLicked.onItemClicked(getItem(position))
            }

        }


    }
    fun setUpListener(itemCLicked: ItemCLickedListener){
        mItemCLicked = itemCLicked
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(countryDetails: CountryDetails, context: Context) {
            itemView.country.text = countryDetails.name
            SvgLoader.pluck()
                .with(context as Activity?)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(countryDetails.flag, itemView.flag)
        }
    }

    interface ItemCLickedListener {
        fun onItemClicked(countryDetails: CountryDetails)
    }

}
package via.rider.interview.ridercodinginterview.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import via.rider.interview.ridercodinginterview.data.PrimeData

object PrimeComparator : DiffUtil.ItemCallback < PrimeData>() {


    override fun areItemsTheSame(oldItem: PrimeData, newItem: PrimeData): Boolean {
       return oldItem.index == newItem.index

    }

    override fun areContentsTheSame(oldItem: PrimeData, newItem: PrimeData): Boolean {
        return oldItem.value == newItem.value
    }
}
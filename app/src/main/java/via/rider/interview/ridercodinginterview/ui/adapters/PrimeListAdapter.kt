package via.rider.interview.ridercodinginterview.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import via.rider.interview.ridercodinginterview.R
import via.rider.interview.ridercodinginterview.data.PrimeData

class PrimeListAdapter(diffUtil: DiffUtil.ItemCallback<PrimeData>) :
    PagingDataAdapter < PrimeData , PrimeListAdapter.PrimeListViewHolder> ( diffUtil ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrimeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prime_list_item, parent, false)
        return PrimeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrimeListViewHolder, position: Int) {
        val item = getItem(position)
        val title = String.format("Prime number: ${item?.value.toString()}(index: ${item?.index.toString()})")
        holder.title.text = title
    }

    class PrimeListViewHolder( view : View) : RecyclerView.ViewHolder(view)
    {
        val title: TextView = view.findViewById(R.id.primeTitle)
    }
}
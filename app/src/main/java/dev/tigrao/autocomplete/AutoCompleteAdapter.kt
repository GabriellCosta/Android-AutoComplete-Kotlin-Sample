package dev.tigrao.autocomplete

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter

private const val NON_RESOURCE = 0

class AutoCompleteAdapter(
    private val dogList: List<CustomDogs>,
    context: Context,
    private val clickListener: (CustomDogs) -> Unit
) : ArrayAdapter<CustomDogs>(context, NON_RESOURCE, dogList) {

    private val filteredDogs = mutableListOf<CustomDogs>()

    override fun getCount(): Int {
        return filteredDogs.size
    }

    override fun getFilter(): Filter {
        return FilterCustomDogs(dogList, ::onPerformFilter)
    }

    private fun onPerformFilter(toFilter: List<CustomDogs>) {
        filteredDogs.clear()
        filteredDogs.addAll(toFilter)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val viewHolder = if (convertView == null) {
            DogViewHolder(context, parent)
        } else {
            convertView.tag as DogViewHolder
        }

        val item = filteredDogs[position]

        viewHolder.bind(item, clickListener)

        return viewHolder.itemView
    }
}

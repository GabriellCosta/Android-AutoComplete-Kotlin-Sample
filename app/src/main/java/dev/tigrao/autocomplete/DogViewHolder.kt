package dev.tigrao.autocomplete

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

data class DogViewHolder(val itemView: View) {

    companion object {
        operator fun invoke(context: Context, parent: ViewGroup): DogViewHolder {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)

            return DogViewHolder(view).also {
                view.tag = it
            }
        }
    }

    private val text: TextView = itemView.findViewById(android.R.id.text1)

    fun bind(item: CustomDogs, clickListener: (CustomDogs) -> Unit) {
        text.apply {
            text = item.name
        }

        itemView.setOnClickListener {
            clickListener(item)
        }
    }
}
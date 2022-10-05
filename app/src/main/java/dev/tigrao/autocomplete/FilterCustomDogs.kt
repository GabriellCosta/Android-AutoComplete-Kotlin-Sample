package dev.tigrao.autocomplete

import android.widget.Filter

class FilterCustomDogs(
    private val original: List<CustomDogs>,
    private val onPublishAction: (List<CustomDogs>) -> Unit
) : Filter() {

    private val filtered = mutableListOf<CustomDogs>()

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        filtered.clear()

        val result = FilterResults()

        if (constraint.isNullOrEmpty()) {
            filtered.addAll(original)
        } else {
            filtered.addAll(
                original.filter {
                    it.name.lowercase().contains(constraint.toString().lowercase())
                }
            )
        }

        result.values = filtered
        result.count = filtered.size

        return result
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults) {
        onPublishAction(results.values as List<CustomDogs>)
    }
}
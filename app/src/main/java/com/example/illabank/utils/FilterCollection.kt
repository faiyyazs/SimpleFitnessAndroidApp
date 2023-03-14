package com.example.illabank.utils

import android.widget.Filter

class FilterCollection<T>(
    private val dataList: List<T>,
    val onFilter: (List<T>) -> Unit,
    val filterCondition: (ch: CharSequence, currentItem: T) -> Boolean
) : Filter() {
    override fun performFiltering(ch: CharSequence?): FilterResults {
        var filteredList = mutableListOf<T>()

        if (ch.isNullOrEmpty()) {
            filteredList = dataList.toMutableList()
        } else {
            for (i in dataList) {
                if (filterCondition(ch, i)) {
                    filteredList.add(i)
                }
            }
        }
        return FilterResults().apply { values = filteredList }
    }

    override fun publishResults(ch: CharSequence?, p1: FilterResults?) {
        try {
            onFilter(p1?.values as List<T>)
        } catch (e: Exception) {
            onFilter(listOf())
        }
    }

}
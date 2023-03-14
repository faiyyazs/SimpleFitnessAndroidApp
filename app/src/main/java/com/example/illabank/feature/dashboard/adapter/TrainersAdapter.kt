package com.example.illabank.feature.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.illabank.R
import com.example.illabank.databinding.ItemTrainerBinding
import com.example.illabank.domain.model.Trainer
import com.example.illabank.utils.FilterCollection
import com.example.illabank.utils.TrainerDiffUtil

class TrainersAdapter(val showEmptyView: (Boolean) -> Unit) :
    ListAdapter<Trainer, TrainersAdapter.DashboardRecyclerViewHolder>(
        TrainerDiffUtil()
    ),
    Filterable {

    private var dataList = listOf<Trainer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardRecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ItemTrainerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_trainer,
            parent,
            false
        )
        return DashboardRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    fun setItems(data: List<Trainer>) {
        dataList = data
        submitList(data)
    }

    class DashboardRecyclerViewHolder(private val mBinding: ItemTrainerBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: Trainer) {
            mBinding.trainerData = item
            mBinding.ivCarousel.setImageResource(item.image)
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return FilterCollection(
            dataList,
            filterCondition = ::performFilter,
            onFilter = ::reloadData
        )
    }

    private fun reloadData(dataList: List<Trainer>) {
        submitList(dataList)
        showEmptyView(dataList.isEmpty())
    }

    private fun performFilter(
        ch: CharSequence,
        currentItem: Trainer
    ): Boolean {
        return currentItem.name.contains(ch, ignoreCase = true)

    }
}




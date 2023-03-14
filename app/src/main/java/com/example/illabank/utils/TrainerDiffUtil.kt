package com.example.illabank.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.illabank.domain.model.Trainer

class TrainerDiffUtil : DiffUtil.ItemCallback<Trainer>() {
    override fun areItemsTheSame(
        oldItem: Trainer,
        newItem: Trainer
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Trainer,
        newItem: Trainer
    ): Boolean {
        return oldItem == newItem
    }
}
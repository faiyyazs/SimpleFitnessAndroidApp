package com.example.illabank.domain.repository

import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer

interface TrainerRepository {
    suspend fun getTrainersList(): List<Trainer>
    suspend fun getLiveShowsList(): List<LiveShow>
}
package com.example.illabank.feature.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.illabank.domain.model.LiveShow
import com.example.illabank.domain.model.Trainer
import com.example.illabank.domain.usecases.FetchLiveShowsUseCase
import com.example.illabank.domain.usecases.FetchLiveShowsUseCaseParams
import com.example.illabank.domain.usecases.FetchTrainersUseCase
import com.example.illabank.domain.usecases.FetchTrainersUseCaseParams
import com.example.illabank.feature.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val fetchTrainersUseCase: FetchTrainersUseCase,
    private val fetchLiveShowsUseCase: FetchLiveShowsUseCase
) :
    BaseViewModel() {

    private val trainersLiveData = MutableLiveData<List<Trainer>>()

    val trainerListData: LiveData<List<Trainer>> = trainersLiveData

    private val liveShowsLiveData = MutableLiveData<List<LiveShow>>()

    val liveShowsData: LiveData<List<LiveShow>> = liveShowsLiveData


    fun fetchTrainers() {
        viewModelScope.launch {
            try {
                val params = FetchTrainersUseCaseParams(

                )
                val trainersList = fetchTrainersUseCase.execute(params)
                trainersLiveData.postValue(trainersList)
            } catch (e: Exception) {
                print("Exception $e");
            }
        }
    }

    fun fetchLiveShows() {
        viewModelScope.launch {
            try {
                val params = FetchLiveShowsUseCaseParams(

                )
                val liveShowsList = fetchLiveShowsUseCase.execute(params)
                liveShowsLiveData.postValue(liveShowsList)
            } catch (e: Exception) {
                print("Exception $e");
            }
        }
    }

}
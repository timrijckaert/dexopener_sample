package com.example.dexopener

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

abstract class MeaningOfLifeViewModel : ViewModel() {
    abstract val meaningOfLifeUserInteraction: MeaningOfLifeUserInteraction
    abstract val meaningOfLife: LiveData<String>

    fun onUserInteraction() {
        meaningOfLifeUserInteraction.onUserInteraction()
    }
}

class MeaningOfLifeViewModelImpl(
    private val meaningOfLifeRepo: MeaningOfLifeRepo,
    override val meaningOfLifeUserInteraction: MeaningOfLifeUserInteraction
) :
    MeaningOfLifeViewModel() {

    override val meaningOfLife: LiveData<String> =
        liveData { meaningOfLifeRepo.stringifiedMeaningOfLife() }
}

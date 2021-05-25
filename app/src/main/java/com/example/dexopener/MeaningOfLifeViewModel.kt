package com.example.dexopener

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

abstract class MeaningOfLifeViewModel : ViewModel() {
    abstract val meaningOfLife: LiveData<String>
    abstract fun onUserInteraction()
}

class MeaningOfLifeViewModelImpl(private val meaningOfLifeRepo: MeaningOfLifeRepo) :
    MeaningOfLifeViewModel() {

    override val meaningOfLife: LiveData<String> =
        liveData { meaningOfLifeRepo.stringifiedMeaningOfLife() }

    override fun onUserInteraction() {
        // Implementation detail of the ViewModel which can be unit tested
    }
}

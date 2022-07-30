package com.example.rewardtrackerstub2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rewardtrackerstub2.data.RewardDao
import com.example.rewardtrackerstub2.model.PartnerDetails
import java.lang.IllegalArgumentException

class RewardViewModel(
    private val rewardDao: RewardDao
) : ViewModel() {

    fun getPartner(id:Long): PartnerDetails {
        return rewardDao.getDetails(id)
    }

    fun addNewPartner(
        guyFirst: String,
        guyLast: String,
        girlFirst: String,
        girlLast: String
    ): Long {
        val newPartner = PartnerDetails(
            guyFirst = guyFirst,
            guyLast = guyLast,
            girlFirst = girlFirst,
            girlLast = girlLast
        )
        return rewardDao.addPartner(newPartner)
    }
}

class RewardViewModelFactory(private val rewardDao: RewardDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RewardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RewardViewModel(rewardDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
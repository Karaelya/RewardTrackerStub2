package com.example.rewardtrackerstub2

import android.app.Application
import com.example.rewardtrackerstub2.data.RewardDatabase

class RewardApplication: Application() {
    val database: RewardDatabase by lazy {RewardDatabase.getDatabase(this)}
}
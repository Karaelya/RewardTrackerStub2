package com.example.rewardtrackerstub2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rewardtrackerstub2.model.Partner
import com.example.rewardtrackerstub2.model.PartnerDetails

@Dao
interface RewardDao {
    @Insert(entity= Partner::class, onConflict = OnConflictStrategy.REPLACE)
    fun addPartner(Partner: PartnerDetails): Long

    @Query(
        """
            SELECT
                guyFirst,
                guyLast,
                girlFirst,
                girlLast
            FROM partner
            WHERE id=:id
        """
    )
    fun getDetails(id: Long): PartnerDetails
}
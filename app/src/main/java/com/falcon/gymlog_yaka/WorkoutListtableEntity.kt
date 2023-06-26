package com.falcon.gymlog_yaka


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutListtableEntity(
    @PrimaryKey val workout_list_id: Int,
    @ColumnInfo(name = "workout_list_name") val workout_list_name: String?

)

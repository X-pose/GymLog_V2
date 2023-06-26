package com.falcon.gymlog_yaka



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutTableEntity(
    @PrimaryKey val workout_id: Int,
    @ColumnInfo(name = "workout_name") val workout_name: String?

)

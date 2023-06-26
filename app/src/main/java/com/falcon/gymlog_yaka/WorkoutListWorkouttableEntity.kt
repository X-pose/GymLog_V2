package com.falcon.gymlog_yaka


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "WorkoutListWorkout",
    primaryKeys = ["workout_list_id", "workout_id"],
    foreignKeys = [ForeignKey(entity = WorkoutListtableEntity::class, parentColumns = ["workout_list_id"],
            childColumns = ["workout_list_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = WorkoutTableEntity::class,
            parentColumns = ["workout_id"],
            childColumns = ["workout_id"],
            onDelete = ForeignKey.CASCADE)
    ],
)
data class WorkoutListWorkout(
    @ColumnInfo(name = "workout_list_id")
    val workoutListId: Long,
    @ColumnInfo(name = "workout_id")
    val workoutId: Long,
    @ColumnInfo(name = "rep_count")
    val repCount: Int,
    @ColumnInfo(name = "load_count")
    val loadCount: Float
)


package com.falcon.gymlog_yaka


import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM WorkoutListtableEntity")
    fun getAllSchedules(): List<WorkoutListtableEntity>

    @Query("SELECT * FROM WorkoutListWorkout WHERE workout_list_id IN (:workout_list_id)")
    fun loadAllByIds(workout_list_id: Int): List<WorkoutListWorkout>

    @Query("INSERT INTO WorkoutListtableEntity (workout_list_name) VALUES (:scheduleName)")
    fun saveNewSchedule(scheduleName:String)


}
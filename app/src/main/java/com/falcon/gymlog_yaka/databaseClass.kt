package com.falcon.gymlog_yaka



import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WorkoutTableEntity::class,WorkoutListtableEntity::class,WorkoutListWorkout::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
}
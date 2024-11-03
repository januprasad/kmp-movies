package com.github.movies.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.movies.data.db.DATABASE_NAME
import com.github.movies.data.db.MoviesDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<MoviesDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder<MoviesDatabase>(
        name = dbFilePath,
        factory =  { MoviesDatabase::class.instantiateImpl() }
    )
}
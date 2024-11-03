package com.github.movies.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.movies.data.db.DATABASE_NAME
import com.github.movies.data.db.MoviesDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<MoviesDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<MoviesDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
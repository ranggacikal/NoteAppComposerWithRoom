package com.ranggacikal.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ranggacikal.noteappcompose.model.Note
import com.ranggacikal.noteappcompose.utils.Converters

@Database(entities =  [Note::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}
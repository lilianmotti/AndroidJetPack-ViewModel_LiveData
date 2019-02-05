package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(
    Note::class),
    version = 1)
abstract class ChoiceDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}

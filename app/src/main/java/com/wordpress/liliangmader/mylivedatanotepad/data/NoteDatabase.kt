package com.wordpress.liliangmader.mylivedatanotepad.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(
    Note::class),
    version = 1)
 abstract class NoteDatabase: RoomDatabase() {

    //if more than one Dao, they should be declared here

    //if Dao ia abstract class, declare constructors here
    //var noteDao = NoteDAO()

    //if Dao is interface, declare fun
    abstract fun noteDao(): NoteDAO


    //singletons, there should be only one instance of the database
    companion object {
        // @Volatile to make this visible to other threads
        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context) {
            if (instance == null) {
                synchronized(NoteDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        NoteDatabase::class.java, "note_database"
                    ).build()

                }
            }
        }
    }
}



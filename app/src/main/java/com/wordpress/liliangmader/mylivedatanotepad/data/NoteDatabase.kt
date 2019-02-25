package com.wordpress.liliangmader.mylivedatanotepad.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext
import android.os.AsyncTask
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.annotation.NonNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Note::class], version = 1, exportSchema = false)
 abstract class NoteDatabase: RoomDatabase() {
// the class should be abstract and extends roomdatabase

    //if more than one Dao, they should be declared here

    //if Dao ia abstract class, declare constructors here
    //var noteDao = NoteDAO()

    //if Dao is interface, declare fun
    //normally we cannot call abstract methods because they do not have a body
    //but since we create the NoteDatabase with the builder below
    //room auto generates all the necessary subclasses and code for this method
    abstract fun noteDao(): NoteDAO


    //singletons, there should be only one instance of the database
    companion object {
        // @Volatile to make this visible to other threads
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): NoteDatabase {
            //room doesn't allow operations on the main thread
            // synchronized(NoteDatabase::class) {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    //.addCallback(roomCallback)
                    .addCallback(NoteDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }


        private class NoteDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.noteDao())
                    }
                }
            }
        }


            fun populateDatabase(noteDao: NoteDAO) {
                noteDao.deleteAllNotes()

                var note = Note("My first note")
                noteDao.insertNote(note)
                note = Note("My second note")
                noteDao.insertNote(note)

            }

    }

}


package com.wordpress.liliangmader.mylivedatanotepad.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext
import android.os.AsyncTask
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.annotation.NonNull



@Database(entities = arrayOf(
    Note::class),
    version = 1)
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
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase? {
            if (instance == null) {
                //room doesn't allow operations on the main thread
                synchronized(NoteDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java, "note_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()

                }
            }
            return instance
        }
        private val roomCallback = object : RoomDatabase.Callback() {
            //onOpen or onCreate
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsync(instance!!).execute()
            }
        }

      /**  fun destroyInstance() {
            instance = null
        }
        **/

    }



    private class PopulateDbAsync internal constructor(db: NoteDatabase) : AsyncTask<Void, Void, Void>() {

        private val noteDao: NoteDAO = db.noteDao()

        override fun doInBackground(vararg params: Void): Void? {
            noteDao.deleteAllNotes()
            noteDao.insertNote(Note("my first note"))
            noteDao.insertNote(Note("my second note"))
            noteDao.insertNote(Note("my third note"))
            return null
        }
    }
}



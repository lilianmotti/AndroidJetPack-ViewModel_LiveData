package com.wordpress.liliangmader.mylivedatanotepad.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// this entity represents one note in the database
@Entity(tableName = "note_table")
//create member variables
class Note(
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "note") var note: String
    //additional functions and variables to be added later
    //SQLite table needs primary keys
    //val creates getters only
    //var creates getters and setters
)
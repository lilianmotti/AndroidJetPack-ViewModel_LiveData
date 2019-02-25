package com.wordpress.liliangmader.mylivedatanotepad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.wordpress.liliangmader.mylivedatanotepad.R
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    private lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp()


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete_all -> {
                noteViewModel.deleteAllNotes()
                Toast.makeText(this,"All notes deleted", Toast.LENGTH_SHORT).show()
               // findNavController().navigate(R.id.action_addNotesFragment_to_listNotesFragment)
                return true
            }
            R.id.action_about -> {
                Toast.makeText(this,"About this app", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


//references for this app
//https://medium.com/@kirillsuslov/how-to-start-using-room-b90d08eb3f0b
//https://resocoder.com/2018/09/07/mvvm-on-android-crash-course-kotlin-android-architecture-components/
//https://www.youtube.com/watch?v=0cg09tlAAQ0&t=65s
//https://medium.com/mindorks/android-architecture-components-room-viewmodel-and-livedata-50611793e4a9
//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/index.html?index=..%2F..index#13
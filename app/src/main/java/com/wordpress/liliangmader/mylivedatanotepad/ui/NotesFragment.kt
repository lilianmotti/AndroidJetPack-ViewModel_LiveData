package com.wordpress.liliangmader.mylivedatanotepad.ui

import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.wordpress.liliangmader.mylivedatanotepad.R
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import kotlinx.android.synthetic.main.notes_fragment.*



class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(NoteViewModel::class.java)

       // val noteRepository = NoteRepository.getInstance(NoteDatabase.getInstance(context)!!.noteDao())

        //attach the fragment to the viewmodel instead of the activity or fragment

        viewModel.allNotes.observe(this, Observer<List<Note>>{

          //  override fun onChanged(t:List<Note>?){
           //     Toast.makeText(context?.applicationContext,"activity changed",Toast.LENGTH_SHORT).show()
          //  }
        })
        /**
        { notes ->
            //update the recycler view
            Toast.makeText(context?.applicationContext,"activity created",Toast.LENGTH_SHORT).show()
            val stringBuilder = StringBuilder()

              notes.forEach{note ->
               stringBuilder.append("$note\n\n")
        }
        //textView_notes.text = stringBuilder.toString()
    })
         **/

        button_save_note.setOnClickListener{
            Toast.makeText(context?.applicationContext,"click",Toast.LENGTH_SHORT).show()
         //   val note = Note(editText_note.text.toString())
        //        viewModel.insertNote(note)
           //     editText_note.setText("")

        }
    }


}

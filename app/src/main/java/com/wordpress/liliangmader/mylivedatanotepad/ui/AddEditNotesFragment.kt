package com.wordpress.liliangmader.mylivedatanotepad.ui


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.wordpress.liliangmader.mylivedatanotepad.R
import com.wordpress.liliangmader.mylivedatanotepad.data.Note
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddNotesFragment : Fragment() {

    private lateinit var editWordView: EditText
    private lateinit var noteViewModel: NoteViewModel
    private val ADD_NOTE_REQUEST = 1
    private val EDIT_NOTE_REQUEST = 2
    private val NOTIFY_UPDATE = 3
    private var getRequest: Int = 0
    private var getArgs = arguments?.getString("arg1")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_notes, container, false)


        getRequest = arguments!!.getInt("request")
        if (getRequest == ADD_NOTE_REQUEST) {
            activity?.setTitle(R.string.add_note)
            editWordView = view.findViewById(R.id.edit_word)
            val button = view.findViewById<Button>(R.id.button_save)
            button.setOnClickListener {
                if (TextUtils.isEmpty(editWordView.text)) {
                    Toast.makeText(context, "Please add note", Toast.LENGTH_SHORT).show()

                } else {
                    val note = editWordView.text.toString()
                    noteViewModel.insertNote(Note(note))
                    Toast.makeText(context, "Note added $note", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_addNotesFragment_to_listNotesFragment)
                    //TODO add more fragments and media player
                }
            }

            return view
        } else if (getRequest == EDIT_NOTE_REQUEST){
            activity?.setTitle(R.string.edit_note)
            getRequest = arguments!!.getInt("request")
            getArgs = arguments!!.getString("arg1")
            val oldNote = getArgs

            editWordView = view.findViewById(R.id.edit_word)
            editWordView.setText(oldNote)
            val button = view.findViewById<Button>(R.id.button_save)
            button.setOnClickListener {
                if (TextUtils.isEmpty(editWordView.text)) {
                    Toast.makeText(context, "Please add note", Toast.LENGTH_SHORT).show()

                } else {
                    val newNote = editWordView.text.toString()
                    val createNote:Note = Note(newNote)
                    createNote.note_text = newNote
                    noteViewModel.updateNote(createNote)
                    Toast.makeText(context, "Note $oldNote updated to ${createNote.note_text}", Toast.LENGTH_SHORT).show()
                    val bundle = Bundle()
                    bundle.putInt("request",NOTIFY_UPDATE)
                    findNavController().navigate(R.id.action_addNotesFragment_to_listNotesFragment, bundle)
                    //TODO add more fragments and media player
                }
            }

            return view

        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            return view

        }

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            noteViewModel = activity?.run{
                ViewModelProviders.of(this).get(NoteViewModel::class.java)
            } ?:throw Exception("Invalid Activity")


    }

   /** override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // passed args :             bundle.putString("arg1","myNote")
        //room needs the primary key
        val getArgs = "received arguments " + arguments?.getString("arg1")
        Toast.makeText(context,getArgs, Toast.LENGTH_SHORT).show()
    }**/



 /**example for activity intents
 companion object {
     const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
 }
**/
}

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
import androidx.navigation.fragment.findNavController

import com.wordpress.liliangmader.mylivedatanotepad.R
import com.wordpress.liliangmader.mylivedatanotepad.data.Note

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflate = inflater.inflate(R.layout.fragment_add_notes, container, false)

        editWordView = inflate.findViewById(R.id.edit_word)
        val button = inflate.findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
           // val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
              //  setResult(Activity.RESULT_CANCELED, replyIntent)
                Toast.makeText(context,"Please add note", Toast.LENGTH_SHORT).show()

            } else {
                val note = editWordView.text.toString()
             //   replyIntent.putExtra(EXTRA_REPLY, word)
             //   setResult(Activity.RESULT_OK, replyIntent)
                noteViewModel.insert(Note(note))
                findNavController().navigate(R.id.action_listNotesFragment_to_addNotesFragment)
                //another way: implement onFragmentInteractionListener
            }
          //  finish()
        }

         return inflate
    }

 /**example for activity intents
 companion object {
     const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
 }
**/
}

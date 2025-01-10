package com.example.androidstudyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddStudentFragment : Fragment() {

    var saveButton: Button? = null
    var cancelButton: Button? = null
    var nameEditText: EditText? = null
    var idEditText: EditText? = null
    var savedMessageTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)

        setupView(view)
        cancelButton?.setOnClickListener(::onCancelClicked)
        saveButton?.setOnClickListener(::onSaveClicked)
        return view
    }

    private fun setupView(view: View?) {
        saveButton = view?.findViewById(R.id.add_student_activity_save_button)
        cancelButton = view?.findViewById(R.id.add_student_activity_cancel_button)

        nameEditText = view?.findViewById(R.id.add_student_activity_name_edit_text)
        idEditText = view?.findViewById(R.id.add_student_activity_id_edit_text)

        savedMessageTextView = view?.findViewById(R.id.add_student_activity_save_message_text_view)
    }

    private fun onSaveClicked(view: View) {
        savedMessageTextView?.text = "Name: ${nameEditText?.text} ID: ${idEditText?.text} is saved!!!..."
    }

    private fun onCancelClicked(view: View) {

    }
}
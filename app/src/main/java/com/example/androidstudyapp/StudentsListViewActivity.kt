package com.example.androidstudyapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidstudyapp.model.Model
import com.example.androidstudyapp.model.Student

class StudentsListViewActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TODO: 1. Set xml layout ✅
        //TODO: 2. Set instance of list view in activity ✅
        //TODO: 3. Set adapter ✅
        //TODO: 4. Create rows layout ✅
        //TODO: 5. Set dynamic data (MVP) ✅
        //TODO: 6. On Click on checkbox ✅

        students = Model.shared.students
        val listView: ListView = findViewById(R.id.students_list_view)
        listView.adapter = StudentAdapter()
    }

    inner class StudentAdapter(): BaseAdapter(){
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflation = LayoutInflater.from(parent?.context)
            val view = convertView ?: inflation.inflate(
                R.layout.student_list_row,
                parent,
                false
            ).apply {
                findViewById<CheckBox>(R.id.student_row_check_box).apply {
                    setOnClickListener { view ->
                        (tag as? Int)?.let { tag ->
                            val student = students?.get(tag)
                            student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                        }
                    }
                }
            }

            val student = students?.get(position)

            val nameTextView: TextView? = view?.findViewById(R.id.student_row_name_text_view)
            val idTextView: TextView? = view?.findViewById(R.id.student_row_id_text_view)
            val checkBox: CheckBox? = view?.findViewById(R.id.student_row_check_box)


            nameTextView?.text = student?.name
            idTextView?.text = student?.id

            checkBox?.apply {
                isChecked = student?.isChecked ?: false
                tag = position
            }
            return view!!
        }

    }
}




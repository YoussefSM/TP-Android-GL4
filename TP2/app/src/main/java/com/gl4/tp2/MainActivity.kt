package com.gl4.tp2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {

    val spinner : Spinner by lazy { findViewById(R.id.spinner) }
    val recyclerView : RecyclerView by lazy { findViewById(R.id.recycler_view_id) }
    val autoComplete : AutoCompleteTextView by lazy { findViewById(R.id.edit_text_id) }

    class Student (var name: String, var lastName: String, var gendre: String ){
        init {
            this.name = name
            this.lastName = lastName
            this.gendre = gendre
            println("La personne est $name , $lastName , $gendre")
        }
    }

    val s1 = Student("youssef","smaoui","male")
    val s2 = Student("mahmoud","smaoui","male")
    val s3 = Student("khadija","smaoui","female")

    var studentList = arrayOf<Student>(s1,s2,s3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var matieres = listOf<String>("Cours","TP")
        var myAdapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matieres)
        spinner.adapter = myAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var matiere = matieres[position]
                Toast.makeText(this@MainActivity,
                    "On a $matiere",
                    Toast.LENGTH_LONG).show()
                if (matiere == "Cours") {
                    recyclerView.apply {
                        adapter = StudentAdapter(arrayOf<Student>(s1,s2,s3))
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                } else if (matiere == "TP") {
                    recyclerView.apply {
                        adapter = StudentAdapter(arrayOf<Student>(s1,s2,s3))
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        var names = listOf<String>(s1.name,s2.name,s3.name)
        var nameAdapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,names)
        autoComplete.setAdapter(nameAdapter)

        autoComplete.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(cs: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
                autoComplete.removeTextChangedListener(this)
                autoComplete.addTextChangedListener(this)
                nameAdapter.getFilter().filter(cs);
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = StudentAdapter(filter(cs.toString()))
            }

            override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
/*
                Toast.makeText(applicationContext, "before text change", Toast.LENGTH_LONG).show()
*/
            }

            override fun afterTextChanged(arg0: Editable) {
/*
                Toast.makeText(applicationContext, "Text changed", Toast.LENGTH_LONG).show()
*/
            }
        })

        /*recyclerView.apply {
            adapter = StudentAdapter(studentList)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }*/
    }

    private fun filter(s: String): Array<Student> {
        var filteredList = arrayOf<Student>()
        for (student in studentList) {
            if (student.name.lowercase(Locale.ROOT)
                    .contains(s.lowercase(Locale.ROOT))
            ) {
                filteredList.plus(student)
                println("************************************************")
                println(student.name)
            }
        }

        return filteredList
    }
}
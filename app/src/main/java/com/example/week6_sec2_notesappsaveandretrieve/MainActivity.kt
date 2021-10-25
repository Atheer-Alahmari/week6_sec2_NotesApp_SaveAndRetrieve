package com.example.week6_sec2_notesappsaveandretrieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var note_ED: EditText
    lateinit var sub_btn: Button
    lateinit var list_RV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        note_ED = findViewById(R.id.note_ED)
        sub_btn = findViewById(R.id.btn_submit)

        list_RV = findViewById(R.id.recycler_View)// Recycler View

        var listNote=ArrayList<String>()





        sub_btn.setOnClickListener {
            var input = note_ED.text.toString()

            //----------------Save DB--------------
            var dbhr = MyDBHelper(applicationContext)
           // var status=
               dbhr.save_date(input)

            Toast.makeText(applicationContext, "Note Added ", Toast.LENGTH_SHORT).show()
            //------------------------Retrieve DB ---------

             listNote=dbhr.retrive()


            list_RV.adapter = RV_Adapter(listNote)
            list_RV.layoutManager = LinearLayoutManager(this)

            list_RV.scrollToPosition(listNote.size - 1)

            note_ED.text.clear()

        }
    }
}